QueueBackEnd
# QueueBackEnd

### Before

Default port this webapplication runs is port 8080, to change it you will need to edit application.properties.

### Usage
This is a gradle project.
- You first need to compile this project using gradle.

## Endpoints

 * **/room/all**
  To access all the rooms
 * **/room/get/{roomid}**
  To access one specific room
 * **/room/queue/{roomid}**
  To access one specific queue
 * **room/join/{roomid}/{name}**
  To join a specific room
 * **room/leave/{roomid}/{name}**
  To leave a specific room:
 * **room/deleteat/{roomid}/{userid}**
  To delete someone from the queue by its id
 * **room/clear/{roomid}**
  To fully clear a queue
 * **room/delete/{roomid}**
  To delete a room
 * **room/create**
  To create a room
 * **authenticate**
  To pseudo authenticate
  * **isAuthenticated**
  To check authentication
  * **unAuthenticate**
  To pseudo unAuthenticate
