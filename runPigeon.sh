flutter pub run pigeon \
--input pigeons/messaging.dart \
--dart_out lib/pigeon.dart \
--objc_header_out ios/Runner/pigeon.h \
--objc_source_out ios/Runner/pigeon.m \
--java_out ./android/app/src/main/java/io/flutter/plugins/Pigeon.java \
--java_package "com.example.flutter_android_battery_level"