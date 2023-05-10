![image](https://user-images.githubusercontent.com/487999/79708354-29074a80-82fa-11ea-80df-0db3962fb453.png)

# 과제 - 음식배달

1. EventStorming Model : Design Level
![image](https://github.com/Sunhokim90/example-food-delivery/assets/132859955/05beeafc-59f5-4809-bf5e-2ab481cc1322)

2. Saga (Pub / Sub)
 .- front BC의 Statusupdate policy
 ![image](https://github.com/Sunhokim90/example-food-delivery/assets/132859955/ac20b6d9-38bd-4f82-9794-bf26be5d692c)
 ![image](https://github.com/Sunhokim90/example-food-delivery/assets/132859955/3e024e63-45ec-4ec7-adb2-3c273cb8663c)
 ![image](https://github.com/Sunhokim90/example-food-delivery/assets/132859955/1fddbd7c-d6b7-46c7-abe7-9968ab3e52fe) 
 ![image](https://github.com/Sunhokim90/example-food-delivery/assets/132859955/86a0bbcc-a276-4aaf-b341-7c6f829c7074)
 ![image](https://github.com/Sunhokim90/example-food-delivery/assets/132859955/cfb8324f-9044-4156-80b0-b9339150651e)

3. CQRS    
.- Read Model Attributes      
 ![image](https://github.com/Sunhokim90/example-food-delivery/assets/132859955/874d406a-032b-45e5-9bd9-ad5d62a4261d)      
.- Read Model Create      
 ![image](https://github.com/Sunhokim90/example-food-delivery/assets/132859955/58792bfd-a2fc-4480-9444-7bf1350755ce)    
.- Read Model data Update    
 ![image](https://github.com/Sunhokim90/example-food-delivery/assets/132859955/4cacf92d-632b-473c-be04-e7b66396370f)    
 ![image](https://github.com/Sunhokim90/example-food-delivery/assets/132859955/0bec3afd-c3e9-48a3-be7c-ff2224c4d429)    
.- Read Model Delete    
 ![image](https://github.com/Sunhokim90/example-food-delivery/assets/132859955/5ef87925-2830-4ecc-8633-a9700e03a55b)    

4. Compensation / Correlation
 ![image](https://github.com/Sunhokim90/example-food-delivery/assets/132859955/5dca6913-d120-4253-bef0-b88c79bcc72a)    
 ![image](https://github.com/Sunhokim90/example-food-delivery/assets/132859955/1ca33c65-fa4d-4774-a582-174b04510e09)    




## Model
www.msaez.io/#/storming/examplefooddelivery001

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- front
- store
- Rider
- DashBoard


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- front
```
 http :8088/orders id="id" cutomerID="cutomerID" storeName="storeName" selectManu="selectManu" price="price" status="status" 
```
- store
```
 http :8088/owners id="id" orderID="orderID" storeName="storeName" status="status" 
```
- Rider
```
 http :8088/riders id="id" orderID="orderID" riderID="riderID" status="status" 
```
- DashBoard
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

