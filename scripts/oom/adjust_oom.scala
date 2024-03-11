import scala.sys.process._
import scala.io.Source

object OomAdjuster extends App {

  // Function to retrieve the PID of the Neo4j process
  def getNeo4jPid: Option[String] = {
    val pids = "pgrep -f neo4j".!!.split("\\s+").toList
    val filteredPids = pids.filterNot(pid => "ps -p $pid -o comm=".!!.trim.contains("scala"))
    filteredPids.headOption
  }

  // Function to adjust the oom_score_adj value
  def adjustOomScore(pid: String, score: Int): Unit = {
    val cmd = s"echo $score > /proc/$pid/oom_score_adj"
    Process(Seq("sudo", "sh", "-c", cmd)).!
  }

  // Main logic to periodically check and adjust the oom_score_adj
  while (true) {
    getNeo4jPid match {
      case Some(neo4jPid) =>
        val runtime = Runtime.getRuntime
        val usedMemory = (runtime.totalMemory - runtime.freeMemory) / (1024 * 1024)
        val maxMemory = runtime.maxMemory / (1024 * 1024)

        if (usedMemory.toDouble / maxMemory > 0.8) { // If more than 80% memory is used
          adjustOomScore(neo4jPid, -500) // Make it less likely to be killed
        } else {
          adjustOomScore(neo4jPid, 0) // Set to default
        }

      case None =>
        println("Neo4j PID not found. Ensure Neo4j is running.")
    }
    Thread.sleep(60000) // Check every minute
  }
}