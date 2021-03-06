// Autogenerated from Pigeon (v2.0.3), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package com.example.flutter_android_battery_level;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/** Generated class from Pigeon. */
@SuppressWarnings({ "unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression" })
public class Pigeon {

  /** Generated class from Pigeon that represents data sent in messages. */
  public static class MyMessage {
    private @NonNull String title;

    public @NonNull String getTitle() {
      return title;
    }

    public void setTitle(@NonNull String setterArg) {
      if (setterArg == null) {
        throw new IllegalStateException("Nonnull field \"title\" is null.");
      }
      this.title = setterArg;
    }

    private @NonNull String body;

    public @NonNull String getBody() {
      return body;
    }

    public void setBody(@NonNull String setterArg) {
      if (setterArg == null) {
        throw new IllegalStateException("Nonnull field \"body\" is null.");
      }
      this.body = setterArg;
    }

    private @NonNull String email;

    public @NonNull String getEmail() {
      return email;
    }

    public void setEmail(@NonNull String setterArg) {
      if (setterArg == null) {
        throw new IllegalStateException("Nonnull field \"email\" is null.");
      }
      this.email = setterArg;
    }

    /** Constructor is private to enforce null safety; use Builder. */
    private MyMessage() {
    }

    public static final class Builder {
      private @Nullable String title;

      public @NonNull Builder setTitle(@NonNull String setterArg) {
        this.title = setterArg;
        return this;
      }

      private @Nullable String body;

      public @NonNull Builder setBody(@NonNull String setterArg) {
        this.body = setterArg;
        return this;
      }

      private @Nullable String email;

      public @NonNull Builder setEmail(@NonNull String setterArg) {
        this.email = setterArg;
        return this;
      }

      public @NonNull MyMessage build() {
        MyMessage pigeonReturn = new MyMessage();
        pigeonReturn.setTitle(title);
        pigeonReturn.setBody(body);
        pigeonReturn.setEmail(email);
        return pigeonReturn;
      }
    }

    @NonNull
    Map<String, Object> toMap() {
      Map<String, Object> toMapResult = new HashMap<>();
      toMapResult.put("title", title);
      toMapResult.put("body", body);
      toMapResult.put("email", email);
      return toMapResult;
    }

    static @NonNull MyMessage fromMap(@NonNull Map<String, Object> map) {
      MyMessage pigeonResult = new MyMessage();
      Object title = map.get("title");
      pigeonResult.setTitle((String) title);
      Object body = map.get("body");
      pigeonResult.setBody((String) body);
      Object email = map.get("email");
      pigeonResult.setEmail((String) email);
      return pigeonResult;
    }
  }

  private static class MessageApiCodec extends StandardMessageCodec {
    public static final MessageApiCodec INSTANCE = new MessageApiCodec();

    private MessageApiCodec() {
    }

    @Override
    protected Object readValueOfType(byte type, ByteBuffer buffer) {
      switch (type) {
        case (byte) 128:
          return MyMessage.fromMap((Map<String, Object>) readValue(buffer));

        default:
          return super.readValueOfType(type, buffer);

      }
    }

    @Override
    protected void writeValue(ByteArrayOutputStream stream, Object value) {
      if (value instanceof MyMessage) {
        stream.write(128);
        writeValue(stream, ((MyMessage) value).toMap());
      } else {
        super.writeValue(stream, value);
      }
    }
  }

  /**
   * Generated interface from Pigeon that represents a handler of messages from
   * Flutter.
   */
  public interface MessageApi {
    @NonNull
    List<MyMessage> getMessage(@NonNull String fromEmail);

    /** The codec used by MessageApi. */
    static MessageCodec<Object> getCodec() {
      return MessageApiCodec.INSTANCE;
    }

    /**
     * Sets up an instance of `MessageApi` to handle messages through the
     * `binaryMessenger`.
     */
    static void setup(BinaryMessenger binaryMessenger, MessageApi api) {
      {
        BasicMessageChannel<Object> channel = new BasicMessageChannel<>(binaryMessenger,
            "dev.flutter.pigeon.MessageApi.getMessage", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              ArrayList<Object> args = (ArrayList<Object>) message;
              String fromEmailArg = (String) args.get(0);
              if (fromEmailArg == null) {
                throw new NullPointerException("fromEmailArg unexpectedly null.");
              }
              List<MyMessage> output = api.getMessage(fromEmailArg);
              wrapped.put("result", output);
            } catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
            }
            reply.reply(wrapped);
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }

  private static Map<String, Object> wrapError(Throwable exception) {
    Map<String, Object> errorMap = new HashMap<>();
    errorMap.put("message", exception.toString());
    errorMap.put("code", exception.getClass().getSimpleName());
    errorMap.put("details", "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    return errorMap;
  }
}
