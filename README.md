# Crypto Multimodal Reputability Analysis

This repository contains code and resources related to the analysis of smart contract reputability on the Ethereum blockchain using a multimodal data fusion approach. This project integrates static code features and transactional data to predict smart contract reputability trends over time.

## Table of Contents
- [Overview](#overview)
- [Objectives](#objectives)
- [Methodology](#methodology)
- [Setup](#setup)
- [Data](#data)
- [Models](#models)
- [Experiments](#experiments)
- [Results](#results)
- [Usage](#usage)
- [Contributions](#contributions)
- [References](#references)

## Overview
Smart contract reputability is essential for blockchain security, helping users and developers assess the risk associated with contracts. This research explores a multimodal data fusion framework to enhance reputability prediction by combining static code analysis with dynamic transactional data. This approach is particularly useful for identifying potential vulnerabilities or malicious behavior in real-time, even without explicit reputability labels.

## Objectives
The key objectives of this research are:
1. **Static Code Analysis**: Develop a framework for assessing smart contract reputability based on static code features using boosting algorithms.
2. **Multimodal Data Fusion**: Integrate static code embeddings with transactional data for anomaly detection, capturing reputability patterns over time.
3. **Temporal Sequence Modeling**: Utilize sequence modeling techniques to analyze the evolution of smart contract reputability.

## Methodology
The methodology follows a structured approach:
1. **Data Preprocessing**: Data is preprocessed to handle imbalances between reputable and illicit smart contracts, using augmentation techniques like SMOTE and GANs.
2. **Model Selection**: 
   - **LightGBM** for static code analysis.
   - **Autoencoders** and **sequence models (LSTM, CNN-LSTM with Multihead Attention)** for anomaly detection and temporal modeling.
3. **Evaluation Metrics**: Models are evaluated based on metrics such as ROC AUC, F1 Score, MAE, and MSE, with a focus on recall for the minority class (illicit).

## Setup
To run this repository, follow these setup instructions:

## Prerequisites
- **Python 3.11+**
- **PyTorch**: Required for deep learning models. Install the appropriate version from the [official PyTorch site](https://pytorch.org/get-started/locally/) for your environment (CPU or GPU).
- **CUDA Toolkit** (optional): For GPU acceleration, install the [CUDA Toolkit](https://developer.nvidia.com/cuda-toolkit).

## Installation
1. **Clone the repository**:
   ```bash
   git clone https://github.com/malikcyrus/crypto-multimodal-reputability.git
   cd crypto-multimodal-reputability
  
2. **Install required packages**:
  ```bash
  pip install -r requirements.txt
