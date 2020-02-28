QueueBackEnd
# QueueBackEnd

### Before

Default port this webapplication runs on is port 8080, to change it you will need to edit `application.properties`.

### Usage
This is a gradle project.
- You first need to compile this project using gradle.

## Endpoints

 * **/room/all [GET]**
  To access all the rooms
 * **/room/get/{roomid} [GET]**
  To access one specific room
 * **/room/queue/{roomid} [GET]**
  To access one specific queue
 * **room/join/{roomid}/{name} [GET]**
  To join a specific room
 * **room/leave/{roomid}/{name} [GET]**
  To leave a specific room:
 * **room/deleteat/{roomid}/{userid} [GET]**
  To delete someone from the queue by its id
 * **room/clear/{roomid} [GET]**
  To fully clear a queue
 * **room/delete/{roomid} [GET]**
  To delete a room
 * **room/create [POST]**
  To create a room
 * **authenticate [POST]**
  To pseudo authenticate
  * **isAuthenticated [GET]**
  To check authentication
  * **unAuthenticate [GET]**
  To pseudo unAuthenticate
