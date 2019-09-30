# Android sensors workshop app

Simple Android application that displays and tracks some basic hardware sensors. Made on VSITE Android workshop on 27 September 2019.

![Screenshot](screenshot.png)

Sensor readings are uploaded in background to a remote database via REST API client (as specified in [sensorapi](https://github.com/nekitamo/sensorapi) repository) which in case of upload failure stores them in a local SQLite database.
This initial proof-of-concept version requires a button press for upload of cached readings (for debugging purposes).

