# Minecraft portal plugin

This plugin uses the [GrechWorldAreas](https://github.com/xXNurioXx/GrechWorldAreas) plugin to define and listen
movement of portal areas.

## Portal definition

```yml
world-area-uuid: "74d41144-a2f0-422c-a25b-598745da6f3e"
actions:
  teleport:
    w: "world"
    x: -1
    y: 110
    z: -1
    yaw: 0
    pitch: 0
  messages:
    - "--------------------"
    - "Teleporting &c{playername}&f to another place..."
    - "--------------------"

```
