# np-manager

## Running Locally
The local environment still needs to be configured and has a lot of manual pieces. Working on getting this all configured in docker, will hopefully have that soon. 

Right now you need to have tomcat downloaded locally and use your IDE to deploy the war file on tomcat locally. 

### DB
I have a local instance of mysql that can be run using docker-compose. To run this:

`docker-compose up`

This should get mysql up and running. If you are running this for the first time you will need to get the db structure up. Ssh into the running docker container:
`docker exec -it npmanager_mysql-dev_1 bash`
This will open a prompt inside the mysql container. Now import the sql structure we have using:
`mysql -u root -proot npmanager < /tmp/usr/mysql/npmanager-init.sql`

This will update your local npmanager db and create a basic structure with no data. 


This is still a working progress and I will continue to update. 


    
    
    
