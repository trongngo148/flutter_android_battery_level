// Autogenerated from Pigeon (v2.0.3), do not edit directly.
// See also: https://pub.dev/packages/pigeon
#import <Foundation/Foundation.h>
@protocol FlutterBinaryMessenger;
@protocol FlutterMessageCodec;
@class FlutterError;
@class FlutterStandardTypedData;

NS_ASSUME_NONNULL_BEGIN

@class MyMessage;

@interface MyMessage : NSObject
/// `init` unavailable to enforce nonnull fields, see the `make` class method.
- (instancetype)init NS_UNAVAILABLE;
+ (instancetype)makeWithTitle:(NSString *)title
    body:(NSString *)body
    email:(NSString *)email;
@property(nonatomic, copy) NSString * title;
@property(nonatomic, copy) NSString * body;
@property(nonatomic, copy) NSString * email;
@end

/// The codec used by MessageApi.
NSObject<FlutterMessageCodec> *MessageApiGetCodec(void);

@protocol MessageApi
/// @return `nil` only when `error != nil`.
- (nullable NSArray<MyMessage *> *)getMessageFromEmail:(NSString *)fromEmail error:(FlutterError *_Nullable *_Nonnull)error;
@end

extern void MessageApiSetup(id<FlutterBinaryMessenger> binaryMessenger, NSObject<MessageApi> *_Nullable api);

NS_ASSUME_NONNULL_END
