package com.example.flutter_android_battery_level

class MyMessageApi : Pigeon.MessageApi {
    private val message =
            listOf(
                    Pigeon.MyMessage.Builder()
                            .setTitle("Hello 1")
                            .setEmail("jonathan@gmail.com")
                            .setBody("Hello Jonthan")
                            .build(),
                    Pigeon.MyMessage.Builder()
                            .setTitle("Hello 2")
                            .setEmail("jonathan2@gmail.com")
                            .setBody("Hello Jonthan2")
                            .build(),
            )

    override fun getMessage(fromEmail: String): MutableList<Pigeon.MyMessage> {
        return message.filter { "jonathan@gmail.com" == fromEmail }.toMutableList()
    }
}
