import 'package:pigeon/pigeon.dart';

class MyMessage {
  final String title;
  final String body;
  final String email;

  MyMessage(this.title, this.body, this.email);
}

@HostApi()
abstract class MessageApi {
  List<MyMessage> getMessage(String fromEmail);
}
