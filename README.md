# pix

sudo update-alternatives --config java

sh kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic order_create_topic --from-beginning

sh kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic produceMessage-out-0

sh kafka-topics.sh --list --bootstrap-server localhost:9092

sh kafka-topics.sh --create --topic order_create_topic --bootstrap-server localhost:9092 --partitions <num-particoes> --replication-factor <fator-replicacao>

linux

kafka-console-consumer --bootstrap-server localhost:9092 --topic order_create_topic --from-beginning --property value.deserializer=org.springframework.kafka.support.serializer.JsonDeserializer

kafka-console-consumer --bootstrap-server localhost:9092 --topic saga_consumer_topic

kafka-topics --list --bootstrap-server localhost:9092

kafka-topics --create --topic order_create_topic --bootstrap-server localhost:9092 --partitions <num-particoes> --replication-factor <fator-replicacao>
