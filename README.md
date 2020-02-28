QueueBackEnd
# QueueBackEnd

### Before

Default port this webapplication runs is port 8080, to change it you will need to edit application.properties.

### Usage
This is a gradle project.
- You first need to compile this project using gradle.

-There are multiple endpoints you can access.

  To access all the rooms:
  "/room/all"
  To access one specific room:
  "/room/get/{roomid}"
  To access one specific queue:
  "/room/queue/{roomid}"
  To join a specific room:
  "room/join/{roomid}/{name}"
  To leave a specific room:
  "room/leave/{roomid}/{name}"
  To delete someone from the queue by its id:
  "room/deleteat/{roomid}/{userid}"
  To fully clear a queue:
  "room/clear/{roomid}"
  To delete a room:
  "room/delete/{roomid}"
  To create a room:
  "room/create"
  To pseudo authenticate:
  "authenticate"
  To check authentication:
  "isAuthenticated"
  To pseudo unAuthenticate:
  "unAuthenticate"
