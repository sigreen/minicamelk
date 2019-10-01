# Simple Camel K demo

1. Create a new project called `camel-k-bp`.
2. Deploy Camel K operator into the `camel-k-bp` project using the Operator UI, making sure you create an integration platform and deploy the example integration successfully.  Make sure you wait 5-10 minutes since this items can take a while to install.
3. Ensure the `Knative Eventing Operator`, `Knative Apache Kafka Operator`, `Knative Apache Camel Operator` and `Knative Serving Operator` are installed to the `camel-k-bp` project
4. Setup Blood Pressure
```
oc create -f bp-channel.yaml
```

5. Setup Body Temperature Channel  
```
oc create -f bt-channel.yaml
```

6. Setup Heart Rate Channel  

```
oc create -f hr-channel.yaml

```
7. Create AMQ Broker for MQTT

```
oc new-app --template=amq63-basic --param=MQ_USERNAME=amq --param=MQ_PASSWORD=password --param=MQ_PROTOCOL=mqtt,amqp,openwire

```
8. Setup Strimzi with Topic name my-topic

9. Run the integration that moves Kafka streams to Channel
```
kamel run -d camel-jackson -d camel-kafka SenderChannels.java

```
10. Run the integration that moves MQTT streams to Kafka
```
kamel run -d camel-kafka -d camel-kafka -d camel-mqtt ReceiverMQTT.java
```
11. Run the listener to Blood Pressure Signal
```
kamel run ChannelBP.yaml
```
12. Run the listener to Body Temperature Signal
```
kamel run ChannelBT.yaml
```
13. Run the listener to Heart Rate Signal

```
kamel run ChannelHR.yaml
```

14. Run the simulator that sends MQTT signal
```
kamel run -d camel-jackson -d camel-mqtt SenderMQTT.java
```
