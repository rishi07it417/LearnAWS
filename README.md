# LearnAWS
Learn AWS


# TEST Lambda Logs

2024-08-17T15:10:10.218Z
INIT_START Runtime Version: java:11.v44 Runtime Version ARN: arn:aws:lambda:ap-south-1::runtime:ac12a69af768a0572a5023efc0b0cd35655f419a6cbcdbde6bd6d07d2dd24d7c
2024-08-17T15:10:10.747Z
START RequestId: af9395e0-c3a7-4dd8-bc9e-e734fef0cc1b Version: $LATEST

START RequestId: af9395e0-c3a7-4dd8-bc9e-e734fef0cc1b Version: $LATEST
2024-08-17T15:10:10.762Z
====App Lambda Start :af9395e0-c3a7-4dd8-bc9e-e734fef0cc1b
2024-08-17T15:10:10.762Z
===Input==={name=rishi, course=IT, university=SP}
2024-08-17T15:10:10.762Z
===context===lambdainternal.api.LambdaContext@6f2b958e
2024-08-17T15:10:10.762Z
====App Lambda End :af9395e0-c3a7-4dd8-bc9e-e734fef0cc1b
2024-08-17T15:10:10.784Z
END RequestId: af9395e0-c3a7-4dd8-bc9e-e734fef0cc1b
2024-08-17T15:10:10.784Z
REPORT RequestId: af9395e0-c3a7-4dd8-bc9e-e734fef0cc1b Duration: 34.77 ms




=======================test-ecs-env-variable============================

IN Local 


application.properties file config ########

spring.application.name=test-ecs-env-variable
myenv.name=TEST_ENV
myenv.id=999


api result ####### localhost:8080/api/testenv

{
    "name": "TEST_ENV",
    "id": "999"
}

	





IN ECS Container ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::



ENV variable config:################

myenv.id
value

7
myenv.name
value

AWS



api result ################# http://13.233.124.185:8080/api/testenv

{
    "name": "AWS",
    "id": "7"
}





