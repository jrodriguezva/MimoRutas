#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class SharedAuthService, SharedUser, SharedFirebaseService, SharedGeoJsonServerResultFeature, SharedKotlinUnit, SharedRouteService, SharedGeoJsonServerResult, SharedDataState<__covariant T>, SharedRoute, SharedGeoJsonServerResultCrs, SharedGeoJsonServerResultCompanion, SharedGeoJsonServerResultCrsProperties, SharedGeoJsonServerResultCrsCompanion, SharedGeoJsonServerResultCrsPropertiesCompanion, SharedGeoJsonServerResultFeatureGeometry, SharedGeoJsonServerResultFeatureProperties, SharedGeoJsonServerResultFeatureCompanion, SharedGeoJsonServerResultFeatureGeometryCompanion, SharedGeoJsonServerResultFeaturePropertiesCompanion, SharedGeometrySerializer, SharedKotlinThrowable, SharedKotlinArray<T>, SharedKotlinException, SharedKotlinRuntimeException, SharedKotlinIllegalStateException, SharedKotlinx_serialization_coreSerializersModule, SharedKotlinx_serialization_coreSerialKind, SharedKotlinNothing;

@protocol SharedKotlinx_coroutines_coreFlow, SharedKtorApi, SharedKotlinx_serialization_coreKSerializer, SharedKotlinx_serialization_coreEncoder, SharedKotlinx_serialization_coreSerialDescriptor, SharedKotlinx_serialization_coreSerializationStrategy, SharedKotlinx_serialization_coreDecoder, SharedKotlinx_serialization_coreDeserializationStrategy, SharedKotlinx_coroutines_coreFlowCollector, SharedKotlinx_serialization_coreCompositeEncoder, SharedKotlinAnnotation, SharedKotlinx_serialization_coreCompositeDecoder, SharedKotlinIterator, SharedKotlinx_serialization_coreSerializersModuleCollector, SharedKotlinKClass, SharedKotlinKDeclarationContainer, SharedKotlinKAnnotatedElement, SharedKotlinKClassifier;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface SharedBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end;

@interface SharedBase (SharedBaseCopying) <NSCopying>
@end;

__attribute__((swift_name("KotlinMutableSet")))
@interface SharedMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end;

__attribute__((swift_name("KotlinMutableDictionary")))
@interface SharedMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end;

@interface NSError (NSErrorSharedKotlinException)
@property (readonly) id _Nullable kotlinException;
@end;

__attribute__((swift_name("KotlinNumber")))
@interface SharedNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end;

__attribute__((swift_name("KotlinByte")))
@interface SharedByte : SharedNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end;

__attribute__((swift_name("KotlinUByte")))
@interface SharedUByte : SharedNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end;

__attribute__((swift_name("KotlinShort")))
@interface SharedShort : SharedNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end;

__attribute__((swift_name("KotlinUShort")))
@interface SharedUShort : SharedNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end;

__attribute__((swift_name("KotlinInt")))
@interface SharedInt : SharedNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end;

__attribute__((swift_name("KotlinUInt")))
@interface SharedUInt : SharedNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end;

__attribute__((swift_name("KotlinLong")))
@interface SharedLong : SharedNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end;

__attribute__((swift_name("KotlinULong")))
@interface SharedULong : SharedNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end;

__attribute__((swift_name("KotlinFloat")))
@interface SharedFloat : SharedNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end;

__attribute__((swift_name("KotlinDouble")))
@interface SharedDouble : SharedNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end;

__attribute__((swift_name("KotlinBoolean")))
@interface SharedBoolean : SharedNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthService")))
@interface SharedAuthService : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)authService __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedAuthService *shared __attribute__((swift_name("shared")));
- (BOOL)checkUserLogged __attribute__((swift_name("checkUserLogged()")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)loginEmail:(NSString *)email pass:(NSString *)pass completionHandler:(void (^)(SharedUser * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("login(email:pass:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)registerName:(NSString *)name email:(NSString *)email pass:(NSString *)pass completionHandler:(void (^)(SharedUser * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("register(name:email:pass:completionHandler:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("FirebaseService")))
@interface SharedFirebaseService : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)firebaseService __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedFirebaseService *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_coroutines_coreFlow>)getFavoritesRoutesItemId:(NSString *)itemId __attribute__((swift_name("getFavoritesRoutes(itemId:)")));
- (id<SharedKotlinx_coroutines_coreFlow>)getFavoritesRoutesByIdRouteId:(NSString *)routeId itemId:(int32_t)itemId __attribute__((swift_name("getFavoritesRoutesById(routeId:itemId:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)removeFavoriteItemId:(NSString *)itemId feature:(SharedGeoJsonServerResultFeature *)feature completionHandler:(void (^)(SharedKotlinUnit * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("removeFavorite(itemId:feature:completionHandler:)")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)saveFavoriteItemId:(NSString *)itemId feature:(SharedGeoJsonServerResultFeature *)feature completionHandler:(void (^)(SharedKotlinUnit * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("saveFavorite(itemId:feature:completionHandler:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RouteService")))
@interface SharedRouteService : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)routeService __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedRouteService *shared __attribute__((swift_name("shared")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)getRouteSigren:(NSString *)sigren completionHandler:(void (^)(SharedDataState<SharedGeoJsonServerResult *> * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getRoute(sigren:completionHandler:)")));
- (NSArray<SharedRoute *> *)getRoutes __attribute__((swift_name("getRoutes()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DataState")))
@interface SharedDataState<__covariant T> : SharedBase
- (instancetype)initWithData:(T _Nullable)data exception:(NSString * _Nullable)exception empty:(BOOL)empty loading:(BOOL)loading __attribute__((swift_name("init(data:exception:empty:loading:)"))) __attribute__((objc_designated_initializer));
- (T _Nullable)component1 __attribute__((swift_name("component1()")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()")));
- (BOOL)component3 __attribute__((swift_name("component3()")));
- (BOOL)component4 __attribute__((swift_name("component4()")));
- (SharedDataState<T> *)doCopyData:(T _Nullable)data exception:(NSString * _Nullable)exception empty:(BOOL)empty loading:(BOOL)loading __attribute__((swift_name("doCopy(data:exception:empty:loading:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) T _Nullable data __attribute__((swift_name("data")));
@property (readonly) BOOL empty __attribute__((swift_name("empty")));
@property (readonly) NSString * _Nullable exception __attribute__((swift_name("exception")));
@property (readonly) BOOL loading __attribute__((swift_name("loading")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Route")))
@interface SharedRoute : SharedBase
- (instancetype)initWithName:(NSString *)name args:(NSString *)args __attribute__((swift_name("init(name:args:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (SharedRoute *)doCopyName:(NSString *)name args:(NSString *)args __attribute__((swift_name("doCopy(name:args:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *args __attribute__((swift_name("args")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("User")))
@interface SharedUser : SharedBase
- (instancetype)initWithName:(NSString *)name email:(NSString *)email __attribute__((swift_name("init(name:email:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (SharedUser *)doCopyName:(NSString *)name email:(NSString *)email __attribute__((swift_name("doCopy(name:email:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *email __attribute__((swift_name("email")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end;

__attribute__((swift_name("KtorApi")))
@protocol SharedKtorApi
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)getGeoJsonSigren:(NSString *)sigren completionHandler:(void (^)(SharedGeoJsonServerResult * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getGeoJson(sigren:completionHandler:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("IdecylApiImpl")))
@interface SharedIdecylApiImpl : SharedBase <SharedKtorApi>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)getGeoJsonSigren:(NSString *)sigren completionHandler:(void (^)(SharedGeoJsonServerResult * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getGeoJson(sigren:completionHandler:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GeoJsonServerResult")))
@interface SharedGeoJsonServerResult : SharedBase
- (instancetype)initWithBbox:(NSArray<id> * _Nullable)bbox crs:(SharedGeoJsonServerResultCrs * _Nullable)crs features:(NSArray<SharedGeoJsonServerResultFeature *> * _Nullable)features numberMatched:(SharedInt * _Nullable)numberMatched numberReturned:(SharedInt * _Nullable)numberReturned timeStamp:(NSString * _Nullable)timeStamp totalFeatures:(SharedInt * _Nullable)totalFeatures type:(NSString * _Nullable)type __attribute__((swift_name("init(bbox:crs:features:numberMatched:numberReturned:timeStamp:totalFeatures:type:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedGeoJsonServerResultCompanion *companion __attribute__((swift_name("companion")));
- (NSArray<id> * _Nullable)component1 __attribute__((swift_name("component1()")));
- (SharedGeoJsonServerResultCrs * _Nullable)component2 __attribute__((swift_name("component2()")));
- (NSArray<SharedGeoJsonServerResultFeature *> * _Nullable)component3 __attribute__((swift_name("component3()")));
- (SharedInt * _Nullable)component4 __attribute__((swift_name("component4()")));
- (SharedInt * _Nullable)component5 __attribute__((swift_name("component5()")));
- (NSString * _Nullable)component6 __attribute__((swift_name("component6()")));
- (SharedInt * _Nullable)component7 __attribute__((swift_name("component7()")));
- (NSString * _Nullable)component8 __attribute__((swift_name("component8()")));
- (SharedGeoJsonServerResult *)doCopyBbox:(NSArray<id> * _Nullable)bbox crs:(SharedGeoJsonServerResultCrs * _Nullable)crs features:(NSArray<SharedGeoJsonServerResultFeature *> * _Nullable)features numberMatched:(SharedInt * _Nullable)numberMatched numberReturned:(SharedInt * _Nullable)numberReturned timeStamp:(NSString * _Nullable)timeStamp totalFeatures:(SharedInt * _Nullable)totalFeatures type:(NSString * _Nullable)type __attribute__((swift_name("doCopy(bbox:crs:features:numberMatched:numberReturned:timeStamp:totalFeatures:type:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<id> * _Nullable bbox __attribute__((swift_name("bbox")));
@property (readonly) SharedGeoJsonServerResultCrs * _Nullable crs __attribute__((swift_name("crs")));
@property (readonly) NSArray<SharedGeoJsonServerResultFeature *> * _Nullable features __attribute__((swift_name("features")));
@property (readonly) SharedInt * _Nullable numberMatched __attribute__((swift_name("numberMatched")));
@property (readonly) SharedInt * _Nullable numberReturned __attribute__((swift_name("numberReturned")));
@property (readonly) NSString * _Nullable timeStamp __attribute__((swift_name("timeStamp")));
@property (readonly) SharedInt * _Nullable totalFeatures __attribute__((swift_name("totalFeatures")));
@property (readonly) NSString * _Nullable type __attribute__((swift_name("type")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GeoJsonServerResult.Companion")))
@interface SharedGeoJsonServerResultCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedGeoJsonServerResultCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GeoJsonServerResult.Crs")))
@interface SharedGeoJsonServerResultCrs : SharedBase
- (instancetype)initWithProperties:(SharedGeoJsonServerResultCrsProperties * _Nullable)properties type:(NSString * _Nullable)type __attribute__((swift_name("init(properties:type:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedGeoJsonServerResultCrsCompanion *companion __attribute__((swift_name("companion")));
- (SharedGeoJsonServerResultCrsProperties * _Nullable)component1 __attribute__((swift_name("component1()")));
- (NSString * _Nullable)component2 __attribute__((swift_name("component2()")));
- (SharedGeoJsonServerResultCrs *)doCopyProperties:(SharedGeoJsonServerResultCrsProperties * _Nullable)properties type:(NSString * _Nullable)type __attribute__((swift_name("doCopy(properties:type:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) SharedGeoJsonServerResultCrsProperties * _Nullable properties __attribute__((swift_name("properties")));
@property (readonly) NSString * _Nullable type __attribute__((swift_name("type")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GeoJsonServerResult.CrsCompanion")))
@interface SharedGeoJsonServerResultCrsCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedGeoJsonServerResultCrsCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GeoJsonServerResult.CrsProperties")))
@interface SharedGeoJsonServerResultCrsProperties : SharedBase
- (instancetype)initWithName:(NSString * _Nullable)name __attribute__((swift_name("init(name:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedGeoJsonServerResultCrsPropertiesCompanion *companion __attribute__((swift_name("companion")));
- (NSString * _Nullable)component1 __attribute__((swift_name("component1()")));
- (SharedGeoJsonServerResultCrsProperties *)doCopyName:(NSString * _Nullable)name __attribute__((swift_name("doCopy(name:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable name __attribute__((swift_name("name")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GeoJsonServerResult.CrsPropertiesCompanion")))
@interface SharedGeoJsonServerResultCrsPropertiesCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedGeoJsonServerResultCrsPropertiesCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GeoJsonServerResult.Feature")))
@interface SharedGeoJsonServerResultFeature : SharedBase
- (instancetype)initWithBbox:(NSArray<id> * _Nullable)bbox geometry:(SharedGeoJsonServerResultFeatureGeometry * _Nullable)geometry geometryName:(NSString * _Nullable)geometryName id:(NSString * _Nullable)id properties:(SharedGeoJsonServerResultFeatureProperties * _Nullable)properties type:(NSString * _Nullable)type __attribute__((swift_name("init(bbox:geometry:geometryName:id:properties:type:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedGeoJsonServerResultFeatureCompanion *companion __attribute__((swift_name("companion")));
- (NSArray<id> * _Nullable)component1 __attribute__((swift_name("component1()")));
- (SharedGeoJsonServerResultFeatureGeometry * _Nullable)component2 __attribute__((swift_name("component2()")));
- (NSString * _Nullable)component3 __attribute__((swift_name("component3()")));
- (NSString * _Nullable)component4 __attribute__((swift_name("component4()")));
- (SharedGeoJsonServerResultFeatureProperties * _Nullable)component5 __attribute__((swift_name("component5()")));
- (NSString * _Nullable)component6 __attribute__((swift_name("component6()")));
- (SharedGeoJsonServerResultFeature *)doCopyBbox:(NSArray<id> * _Nullable)bbox geometry:(SharedGeoJsonServerResultFeatureGeometry * _Nullable)geometry geometryName:(NSString * _Nullable)geometryName id:(NSString * _Nullable)id properties:(SharedGeoJsonServerResultFeatureProperties * _Nullable)properties type:(NSString * _Nullable)type __attribute__((swift_name("doCopy(bbox:geometry:geometryName:id:properties:type:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSArray<id> * _Nullable bbox __attribute__((swift_name("bbox")));
@property (readonly) SharedGeoJsonServerResultFeatureGeometry * _Nullable geometry __attribute__((swift_name("geometry")));
@property (readonly) NSString * _Nullable geometryName __attribute__((swift_name("geometryName")));
@property (readonly) NSString * _Nullable id __attribute__((swift_name("id")));
@property (readonly) SharedGeoJsonServerResultFeatureProperties * _Nullable properties __attribute__((swift_name("properties")));
@property (readonly) NSString * _Nullable type __attribute__((swift_name("type")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GeoJsonServerResult.FeatureCompanion")))
@interface SharedGeoJsonServerResultFeatureCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedGeoJsonServerResultFeatureCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GeoJsonServerResult.FeatureGeometry")))
@interface SharedGeoJsonServerResultFeatureGeometry : SharedBase
- (instancetype)initWithType:(NSString * _Nullable)type coordinates:(id)coordinates __attribute__((swift_name("init(type:coordinates:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedGeoJsonServerResultFeatureGeometryCompanion *companion __attribute__((swift_name("companion")));
- (NSString * _Nullable)component1 __attribute__((swift_name("component1()")));
- (id)component2 __attribute__((swift_name("component2()")));
- (SharedGeoJsonServerResultFeatureGeometry *)doCopyType:(NSString * _Nullable)type coordinates:(id)coordinates __attribute__((swift_name("doCopy(type:coordinates:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id coordinates __attribute__((swift_name("coordinates")));
@property (readonly) NSString * _Nullable type __attribute__((swift_name("type")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GeoJsonServerResult.FeatureGeometryCompanion")))
@interface SharedGeoJsonServerResultFeatureGeometryCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedGeoJsonServerResultFeatureGeometryCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GeoJsonServerResult.FeatureProperties")))
@interface SharedGeoJsonServerResultFeatureProperties : SharedBase
- (instancetype)initWithAtrGrAlerta:(SharedBoolean * _Nullable)atrGrAlerta atrGrId:(SharedInt * _Nullable)atrGrId atrGrTieneQ:(SharedBoolean * _Nullable)atrGrTieneQ atrGrTipo:(SharedInt * _Nullable)atrGrTipo atrGrVisible:(SharedBoolean * _Nullable)atrGrVisible espacioCodigo:(NSString * _Nullable)espacioCodigo espacioFechaDeclaracion:(NSString * _Nullable)espacioFechaDeclaracion espacioNombre:(NSString * _Nullable)espacioNombre espacioSenalizacionExterna:(SharedBoolean * _Nullable)espacioSenalizacionExterna figura:(SharedInt * _Nullable)figura figuraNombre:(NSString * _Nullable)figuraNombre rutaimg:(NSString * _Nullable)rutaimg accDisId:(SharedInt * _Nullable)accDisId accId:(SharedInt * _Nullable)accId campamentoCabanas:(SharedInt * _Nullable)campamentoCabanas campamentoCategoria:(SharedInt * _Nullable)campamentoCategoria campamentoJuvenil:(SharedBoolean * _Nullable)campamentoJuvenil campamentoParcelas:(SharedInt * _Nullable)campamentoParcelas campamentoServicioInformativo:(SharedBoolean * _Nullable)campamentoServicioInformativo cerramientoId:(SharedInt * _Nullable)cerramientoId cerramientoMaterialId:(SharedInt * _Nullable)cerramientoMaterialId equipACodigo:(NSString * _Nullable)equipACodigo equipAEstadoFecha:(NSString * _Nullable)equipAEstadoFecha equipAFechaDeclaracion:(NSString * _Nullable)equipAFechaDeclaracion equipAObservaciones:(NSString * _Nullable)equipAObservaciones equipBAccesoModo:(NSString * _Nullable)equipBAccesoModo equipBNombre:(NSString * _Nullable)equipBNombre equipBSenalizacionExt:(SharedBoolean * _Nullable)equipBSenalizacionExt equipBSuperficieAprox:(SharedInt * _Nullable)equipBSuperficieAprox equipBTieneInteres:(SharedBoolean * _Nullable)equipBTieneInteres estadoId:(SharedInt * _Nullable)estadoId web:(NSString * _Nullable)web __attribute__((swift_name("init(atrGrAlerta:atrGrId:atrGrTieneQ:atrGrTipo:atrGrVisible:espacioCodigo:espacioFechaDeclaracion:espacioNombre:espacioSenalizacionExterna:figura:figuraNombre:rutaimg:accDisId:accId:campamentoCabanas:campamentoCategoria:campamentoJuvenil:campamentoParcelas:campamentoServicioInformativo:cerramientoId:cerramientoMaterialId:equipACodigo:equipAEstadoFecha:equipAFechaDeclaracion:equipAObservaciones:equipBAccesoModo:equipBNombre:equipBSenalizacionExt:equipBSuperficieAprox:equipBTieneInteres:estadoId:web:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) SharedGeoJsonServerResultFeaturePropertiesCompanion *companion __attribute__((swift_name("companion")));
- (SharedBoolean * _Nullable)component1 __attribute__((swift_name("component1()")));
- (SharedInt * _Nullable)component10 __attribute__((swift_name("component10()")));
- (NSString * _Nullable)component11 __attribute__((swift_name("component11()")));
- (NSString * _Nullable)component12 __attribute__((swift_name("component12()")));
- (SharedInt * _Nullable)component13 __attribute__((swift_name("component13()")));
- (SharedInt * _Nullable)component14 __attribute__((swift_name("component14()")));
- (SharedInt * _Nullable)component15 __attribute__((swift_name("component15()")));
- (SharedInt * _Nullable)component16 __attribute__((swift_name("component16()")));
- (SharedBoolean * _Nullable)component17 __attribute__((swift_name("component17()")));
- (SharedInt * _Nullable)component18 __attribute__((swift_name("component18()")));
- (SharedBoolean * _Nullable)component19 __attribute__((swift_name("component19()")));
- (SharedInt * _Nullable)component2 __attribute__((swift_name("component2()")));
- (SharedInt * _Nullable)component20 __attribute__((swift_name("component20()")));
- (SharedInt * _Nullable)component21 __attribute__((swift_name("component21()")));
- (NSString * _Nullable)component22 __attribute__((swift_name("component22()")));
- (NSString * _Nullable)component23 __attribute__((swift_name("component23()")));
- (NSString * _Nullable)component24 __attribute__((swift_name("component24()")));
- (NSString * _Nullable)component25 __attribute__((swift_name("component25()")));
- (NSString * _Nullable)component26 __attribute__((swift_name("component26()")));
- (NSString * _Nullable)component27 __attribute__((swift_name("component27()")));
- (SharedBoolean * _Nullable)component28 __attribute__((swift_name("component28()")));
- (SharedInt * _Nullable)component29 __attribute__((swift_name("component29()")));
- (SharedBoolean * _Nullable)component3 __attribute__((swift_name("component3()")));
- (SharedBoolean * _Nullable)component30 __attribute__((swift_name("component30()")));
- (SharedInt * _Nullable)component31 __attribute__((swift_name("component31()")));
- (NSString * _Nullable)component32 __attribute__((swift_name("component32()")));
- (SharedInt * _Nullable)component4 __attribute__((swift_name("component4()")));
- (SharedBoolean * _Nullable)component5 __attribute__((swift_name("component5()")));
- (NSString * _Nullable)component6 __attribute__((swift_name("component6()")));
- (NSString * _Nullable)component7 __attribute__((swift_name("component7()")));
- (NSString * _Nullable)component8 __attribute__((swift_name("component8()")));
- (SharedBoolean * _Nullable)component9 __attribute__((swift_name("component9()")));
- (SharedGeoJsonServerResultFeatureProperties *)doCopyAtrGrAlerta:(SharedBoolean * _Nullable)atrGrAlerta atrGrId:(SharedInt * _Nullable)atrGrId atrGrTieneQ:(SharedBoolean * _Nullable)atrGrTieneQ atrGrTipo:(SharedInt * _Nullable)atrGrTipo atrGrVisible:(SharedBoolean * _Nullable)atrGrVisible espacioCodigo:(NSString * _Nullable)espacioCodigo espacioFechaDeclaracion:(NSString * _Nullable)espacioFechaDeclaracion espacioNombre:(NSString * _Nullable)espacioNombre espacioSenalizacionExterna:(SharedBoolean * _Nullable)espacioSenalizacionExterna figura:(SharedInt * _Nullable)figura figuraNombre:(NSString * _Nullable)figuraNombre rutaimg:(NSString * _Nullable)rutaimg accDisId:(SharedInt * _Nullable)accDisId accId:(SharedInt * _Nullable)accId campamentoCabanas:(SharedInt * _Nullable)campamentoCabanas campamentoCategoria:(SharedInt * _Nullable)campamentoCategoria campamentoJuvenil:(SharedBoolean * _Nullable)campamentoJuvenil campamentoParcelas:(SharedInt * _Nullable)campamentoParcelas campamentoServicioInformativo:(SharedBoolean * _Nullable)campamentoServicioInformativo cerramientoId:(SharedInt * _Nullable)cerramientoId cerramientoMaterialId:(SharedInt * _Nullable)cerramientoMaterialId equipACodigo:(NSString * _Nullable)equipACodigo equipAEstadoFecha:(NSString * _Nullable)equipAEstadoFecha equipAFechaDeclaracion:(NSString * _Nullable)equipAFechaDeclaracion equipAObservaciones:(NSString * _Nullable)equipAObservaciones equipBAccesoModo:(NSString * _Nullable)equipBAccesoModo equipBNombre:(NSString * _Nullable)equipBNombre equipBSenalizacionExt:(SharedBoolean * _Nullable)equipBSenalizacionExt equipBSuperficieAprox:(SharedInt * _Nullable)equipBSuperficieAprox equipBTieneInteres:(SharedBoolean * _Nullable)equipBTieneInteres estadoId:(SharedInt * _Nullable)estadoId web:(NSString * _Nullable)web __attribute__((swift_name("doCopy(atrGrAlerta:atrGrId:atrGrTieneQ:atrGrTipo:atrGrVisible:espacioCodigo:espacioFechaDeclaracion:espacioNombre:espacioSenalizacionExterna:figura:figuraNombre:rutaimg:accDisId:accId:campamentoCabanas:campamentoCategoria:campamentoJuvenil:campamentoParcelas:campamentoServicioInformativo:cerramientoId:cerramientoMaterialId:equipACodigo:equipAEstadoFecha:equipAFechaDeclaracion:equipAObservaciones:equipBAccesoModo:equipBNombre:equipBSenalizacionExt:equipBSuperficieAprox:equipBTieneInteres:estadoId:web:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) SharedInt * _Nullable accDisId __attribute__((swift_name("accDisId")));
@property (readonly) SharedInt * _Nullable accId __attribute__((swift_name("accId")));
@property (readonly) SharedBoolean * _Nullable atrGrAlerta __attribute__((swift_name("atrGrAlerta")));
@property (readonly) SharedInt * _Nullable atrGrId __attribute__((swift_name("atrGrId")));
@property (readonly) SharedBoolean * _Nullable atrGrTieneQ __attribute__((swift_name("atrGrTieneQ")));
@property (readonly) SharedInt * _Nullable atrGrTipo __attribute__((swift_name("atrGrTipo")));
@property (readonly) SharedBoolean * _Nullable atrGrVisible __attribute__((swift_name("atrGrVisible")));
@property (readonly) SharedInt * _Nullable campamentoCabanas __attribute__((swift_name("campamentoCabanas")));
@property (readonly) SharedInt * _Nullable campamentoCategoria __attribute__((swift_name("campamentoCategoria")));
@property (readonly) SharedBoolean * _Nullable campamentoJuvenil __attribute__((swift_name("campamentoJuvenil")));
@property (readonly) SharedInt * _Nullable campamentoParcelas __attribute__((swift_name("campamentoParcelas")));
@property (readonly) SharedBoolean * _Nullable campamentoServicioInformativo __attribute__((swift_name("campamentoServicioInformativo")));
@property (readonly) SharedInt * _Nullable cerramientoId __attribute__((swift_name("cerramientoId")));
@property (readonly) SharedInt * _Nullable cerramientoMaterialId __attribute__((swift_name("cerramientoMaterialId")));
@property (readonly) NSString * _Nullable equipACodigo __attribute__((swift_name("equipACodigo")));
@property (readonly) NSString * _Nullable equipAEstadoFecha __attribute__((swift_name("equipAEstadoFecha")));
@property (readonly) NSString * _Nullable equipAFechaDeclaracion __attribute__((swift_name("equipAFechaDeclaracion")));
@property (readonly) NSString * _Nullable equipAObservaciones __attribute__((swift_name("equipAObservaciones")));
@property (readonly) NSString * _Nullable equipBAccesoModo __attribute__((swift_name("equipBAccesoModo")));
@property (readonly) NSString * _Nullable equipBNombre __attribute__((swift_name("equipBNombre")));
@property (readonly) SharedBoolean * _Nullable equipBSenalizacionExt __attribute__((swift_name("equipBSenalizacionExt")));
@property (readonly) SharedInt * _Nullable equipBSuperficieAprox __attribute__((swift_name("equipBSuperficieAprox")));
@property (readonly) SharedBoolean * _Nullable equipBTieneInteres __attribute__((swift_name("equipBTieneInteres")));
@property (readonly) NSString * _Nullable espacioCodigo __attribute__((swift_name("espacioCodigo")));
@property (readonly) NSString * _Nullable espacioFechaDeclaracion __attribute__((swift_name("espacioFechaDeclaracion")));
@property (readonly) NSString * _Nullable espacioNombre __attribute__((swift_name("espacioNombre")));
@property (readonly) SharedBoolean * _Nullable espacioSenalizacionExterna __attribute__((swift_name("espacioSenalizacionExterna")));
@property (readonly) SharedInt * _Nullable estadoId __attribute__((swift_name("estadoId")));
@property (readonly) SharedInt * _Nullable figura __attribute__((swift_name("figura")));
@property (readonly) NSString * _Nullable figuraNombre __attribute__((swift_name("figuraNombre")));
@property (readonly) NSString * _Nullable rutaimg __attribute__((swift_name("rutaimg")));
@property (readonly) NSString * _Nullable web __attribute__((swift_name("web")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GeoJsonServerResult.FeaturePropertiesCompanion")))
@interface SharedGeoJsonServerResultFeaturePropertiesCompanion : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedGeoJsonServerResultFeaturePropertiesCompanion *shared __attribute__((swift_name("shared")));
- (id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerializationStrategy")))
@protocol SharedKotlinx_serialization_coreSerializationStrategy
@required
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(id _Nullable)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreDeserializationStrategy")))
@protocol SharedKotlinx_serialization_coreDeserializationStrategy
@required
- (id _Nullable)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreKSerializer")))
@protocol SharedKotlinx_serialization_coreKSerializer <SharedKotlinx_serialization_coreSerializationStrategy, SharedKotlinx_serialization_coreDeserializationStrategy>
@required
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("GeometrySerializer")))
@interface SharedGeometrySerializer : SharedBase <SharedKotlinx_serialization_coreKSerializer>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)geometrySerializer __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedGeometrySerializer *shared __attribute__((swift_name("shared")));
- (SharedGeoJsonServerResultFeatureGeometry *)deserializeDecoder:(id<SharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<SharedKotlinx_serialization_coreEncoder>)encoder value:(SharedGeoJsonServerResultFeatureGeometry *)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<SharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end;

__attribute__((swift_name("KotlinThrowable")))
@interface SharedKotlinThrowable : SharedBase
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (SharedKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) SharedKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end;

__attribute__((swift_name("KotlinException")))
@interface SharedKotlinException : SharedKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinRuntimeException")))
@interface SharedKotlinRuntimeException : SharedKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinIllegalStateException")))
@interface SharedKotlinIllegalStateException : SharedKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("KotlinCancellationException")))
@interface SharedKotlinCancellationException : SharedKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(SharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreFlow")))
@protocol SharedKotlinx_coroutines_coreFlow
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)collectCollector:(id<SharedKotlinx_coroutines_coreFlowCollector>)collector completionHandler:(void (^)(SharedKotlinUnit * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("collect(collector:completionHandler:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinUnit")))
@interface SharedKotlinUnit : SharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)unit __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) SharedKotlinUnit *shared __attribute__((swift_name("shared")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreEncoder")))
@protocol SharedKotlinx_serialization_coreEncoder
@required
- (id<SharedKotlinx_serialization_coreCompositeEncoder>)beginCollectionDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor collectionSize:(int32_t)collectionSize __attribute__((swift_name("beginCollection(descriptor:collectionSize:)")));
- (id<SharedKotlinx_serialization_coreCompositeEncoder>)beginStructureDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (void)encodeBooleanValue:(BOOL)value __attribute__((swift_name("encodeBoolean(value:)")));
- (void)encodeByteValue:(int8_t)value __attribute__((swift_name("encodeByte(value:)")));
- (void)encodeCharValue:(unichar)value __attribute__((swift_name("encodeChar(value:)")));
- (void)encodeDoubleValue:(double)value __attribute__((swift_name("encodeDouble(value:)")));
- (void)encodeEnumEnumDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)enumDescriptor index:(int32_t)index __attribute__((swift_name("encodeEnum(enumDescriptor:index:)")));
- (void)encodeFloatValue:(float)value __attribute__((swift_name("encodeFloat(value:)")));
- (id<SharedKotlinx_serialization_coreEncoder>)encodeInlineInlineDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)inlineDescriptor __attribute__((swift_name("encodeInline(inlineDescriptor:)")));
- (void)encodeIntValue:(int32_t)value __attribute__((swift_name("encodeInt(value:)")));
- (void)encodeLongValue:(int64_t)value __attribute__((swift_name("encodeLong(value:)")));
- (void)encodeNotNullMark __attribute__((swift_name("encodeNotNullMark()")));
- (void)encodeNull __attribute__((swift_name("encodeNull()")));
- (void)encodeNullableSerializableValueSerializer:(id<SharedKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableValue(serializer:value:)")));
- (void)encodeSerializableValueSerializer:(id<SharedKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableValue(serializer:value:)")));
- (void)encodeShortValue:(int16_t)value __attribute__((swift_name("encodeShort(value:)")));
- (void)encodeStringValue:(NSString *)value __attribute__((swift_name("encodeString(value:)")));
@property (readonly) SharedKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerialDescriptor")))
@protocol SharedKotlinx_serialization_coreSerialDescriptor
@required
- (NSArray<id<SharedKotlinAnnotation>> *)getElementAnnotationsIndex:(int32_t)index __attribute__((swift_name("getElementAnnotations(index:)")));
- (id<SharedKotlinx_serialization_coreSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));
- (int32_t)getElementIndexName:(NSString *)name __attribute__((swift_name("getElementIndex(name:)")));
- (NSString *)getElementNameIndex:(int32_t)index __attribute__((swift_name("getElementName(index:)")));
- (BOOL)isElementOptionalIndex:(int32_t)index __attribute__((swift_name("isElementOptional(index:)")));
@property (readonly) NSArray<id<SharedKotlinAnnotation>> *annotations __attribute__((swift_name("annotations")));
@property (readonly) int32_t elementsCount __attribute__((swift_name("elementsCount")));
@property (readonly) BOOL isInline __attribute__((swift_name("isInline")));
@property (readonly) BOOL isNullable __attribute__((swift_name("isNullable")));
@property (readonly) SharedKotlinx_serialization_coreSerialKind *kind __attribute__((swift_name("kind")));
@property (readonly) NSString *serialName __attribute__((swift_name("serialName")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreDecoder")))
@protocol SharedKotlinx_serialization_coreDecoder
@required
- (id<SharedKotlinx_serialization_coreCompositeDecoder>)beginStructureDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (BOOL)decodeBoolean __attribute__((swift_name("decodeBoolean()")));
- (int8_t)decodeByte __attribute__((swift_name("decodeByte()")));
- (unichar)decodeChar __attribute__((swift_name("decodeChar()")));
- (double)decodeDouble __attribute__((swift_name("decodeDouble()")));
- (int32_t)decodeEnumEnumDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)enumDescriptor __attribute__((swift_name("decodeEnum(enumDescriptor:)")));
- (float)decodeFloat __attribute__((swift_name("decodeFloat()")));
- (id<SharedKotlinx_serialization_coreDecoder>)decodeInlineInlineDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)inlineDescriptor __attribute__((swift_name("decodeInline(inlineDescriptor:)")));
- (int32_t)decodeInt __attribute__((swift_name("decodeInt()")));
- (int64_t)decodeLong __attribute__((swift_name("decodeLong()")));
- (BOOL)decodeNotNullMark __attribute__((swift_name("decodeNotNullMark()")));
- (SharedKotlinNothing * _Nullable)decodeNull __attribute__((swift_name("decodeNull()")));
- (id _Nullable)decodeNullableSerializableValueDeserializer:(id<SharedKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableValue(deserializer:)")));
- (id _Nullable)decodeSerializableValueDeserializer:(id<SharedKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableValue(deserializer:)")));
- (int16_t)decodeShort __attribute__((swift_name("decodeShort()")));
- (NSString *)decodeString __attribute__((swift_name("decodeString()")));
@property (readonly) SharedKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface SharedKotlinArray<T> : SharedBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(SharedInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<SharedKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((swift_name("Kotlinx_coroutines_coreFlowCollector")))
@protocol SharedKotlinx_coroutines_coreFlowCollector
@required

/**
 @note This method converts instances of CancellationException to errors.
 Other uncaught Kotlin exceptions are fatal.
*/
- (void)emitValue:(id _Nullable)value completionHandler:(void (^)(SharedKotlinUnit * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("emit(value:completionHandler:)")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreCompositeEncoder")))
@protocol SharedKotlinx_serialization_coreCompositeEncoder
@required
- (void)encodeBooleanElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(BOOL)value __attribute__((swift_name("encodeBooleanElement(descriptor:index:value:)")));
- (void)encodeByteElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int8_t)value __attribute__((swift_name("encodeByteElement(descriptor:index:value:)")));
- (void)encodeCharElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(unichar)value __attribute__((swift_name("encodeCharElement(descriptor:index:value:)")));
- (void)encodeDoubleElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(double)value __attribute__((swift_name("encodeDoubleElement(descriptor:index:value:)")));
- (void)encodeFloatElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(float)value __attribute__((swift_name("encodeFloatElement(descriptor:index:value:)")));
- (id<SharedKotlinx_serialization_coreEncoder>)encodeInlineElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("encodeInlineElement(descriptor:index:)")));
- (void)encodeIntElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int32_t)value __attribute__((swift_name("encodeIntElement(descriptor:index:value:)")));
- (void)encodeLongElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int64_t)value __attribute__((swift_name("encodeLongElement(descriptor:index:value:)")));
- (void)encodeNullableSerializableElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<SharedKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeSerializableElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<SharedKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeShortElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int16_t)value __attribute__((swift_name("encodeShortElement(descriptor:index:value:)")));
- (void)encodeStringElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(NSString *)value __attribute__((swift_name("encodeStringElement(descriptor:index:value:)")));
- (void)endStructureDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));
- (BOOL)shouldEncodeElementDefaultDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("shouldEncodeElementDefault(descriptor:index:)")));
@property (readonly) SharedKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerializersModule")))
@interface SharedKotlinx_serialization_coreSerializersModule : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)dumpToCollector:(id<SharedKotlinx_serialization_coreSerializersModuleCollector>)collector __attribute__((swift_name("dumpTo(collector:)")));
- (id<SharedKotlinx_serialization_coreKSerializer> _Nullable)getContextualKClass:(id<SharedKotlinKClass>)kClass typeArgumentsSerializers:(NSArray<id<SharedKotlinx_serialization_coreKSerializer>> *)typeArgumentsSerializers __attribute__((swift_name("getContextual(kClass:typeArgumentsSerializers:)")));
- (id<SharedKotlinx_serialization_coreSerializationStrategy> _Nullable)getPolymorphicBaseClass:(id<SharedKotlinKClass>)baseClass value:(id)value __attribute__((swift_name("getPolymorphic(baseClass:value:)")));
- (id<SharedKotlinx_serialization_coreDeserializationStrategy> _Nullable)getPolymorphicBaseClass:(id<SharedKotlinKClass>)baseClass serializedClassName:(NSString * _Nullable)serializedClassName __attribute__((swift_name("getPolymorphic(baseClass:serializedClassName:)")));
@end;

__attribute__((swift_name("KotlinAnnotation")))
@protocol SharedKotlinAnnotation
@required
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerialKind")))
@interface SharedKotlinx_serialization_coreSerialKind : SharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreCompositeDecoder")))
@protocol SharedKotlinx_serialization_coreCompositeDecoder
@required
- (BOOL)decodeBooleanElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeBooleanElement(descriptor:index:)")));
- (int8_t)decodeByteElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeByteElement(descriptor:index:)")));
- (unichar)decodeCharElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeCharElement(descriptor:index:)")));
- (int32_t)decodeCollectionSizeDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeCollectionSize(descriptor:)")));
- (double)decodeDoubleElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeDoubleElement(descriptor:index:)")));
- (int32_t)decodeElementIndexDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeElementIndex(descriptor:)")));
- (float)decodeFloatElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeFloatElement(descriptor:index:)")));
- (id<SharedKotlinx_serialization_coreDecoder>)decodeInlineElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeInlineElement(descriptor:index:)")));
- (int32_t)decodeIntElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeIntElement(descriptor:index:)")));
- (int64_t)decodeLongElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeLongElement(descriptor:index:)")));
- (id _Nullable)decodeNullableSerializableElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<SharedKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeNullableSerializableElement(descriptor:index:deserializer:previousValue:)")));
- (BOOL)decodeSequentially __attribute__((swift_name("decodeSequentially()")));
- (id _Nullable)decodeSerializableElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<SharedKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeSerializableElement(descriptor:index:deserializer:previousValue:)")));
- (int16_t)decodeShortElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeShortElement(descriptor:index:)")));
- (NSString *)decodeStringElementDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeStringElement(descriptor:index:)")));
- (void)endStructureDescriptor:(id<SharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));
@property (readonly) SharedKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinNothing")))
@interface SharedKotlinNothing : SharedBase
@end;

__attribute__((swift_name("KotlinIterator")))
@protocol SharedKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end;

__attribute__((swift_name("Kotlinx_serialization_coreSerializersModuleCollector")))
@protocol SharedKotlinx_serialization_coreSerializersModuleCollector
@required
- (void)contextualKClass:(id<SharedKotlinKClass>)kClass provider:(id<SharedKotlinx_serialization_coreKSerializer> (^)(NSArray<id<SharedKotlinx_serialization_coreKSerializer>> *))provider __attribute__((swift_name("contextual(kClass:provider:)")));
- (void)contextualKClass:(id<SharedKotlinKClass>)kClass serializer:(id<SharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("contextual(kClass:serializer:)")));
- (void)polymorphicBaseClass:(id<SharedKotlinKClass>)baseClass actualClass:(id<SharedKotlinKClass>)actualClass actualSerializer:(id<SharedKotlinx_serialization_coreKSerializer>)actualSerializer __attribute__((swift_name("polymorphic(baseClass:actualClass:actualSerializer:)")));
- (void)polymorphicDefaultBaseClass:(id<SharedKotlinKClass>)baseClass defaultDeserializerProvider:(id<SharedKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefault(baseClass:defaultDeserializerProvider:)")));
- (void)polymorphicDefaultDeserializerBaseClass:(id<SharedKotlinKClass>)baseClass defaultDeserializerProvider:(id<SharedKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefaultDeserializer(baseClass:defaultDeserializerProvider:)")));
- (void)polymorphicDefaultSerializerBaseClass:(id<SharedKotlinKClass>)baseClass defaultSerializerProvider:(id<SharedKotlinx_serialization_coreSerializationStrategy> _Nullable (^)(id))defaultSerializerProvider __attribute__((swift_name("polymorphicDefaultSerializer(baseClass:defaultSerializerProvider:)")));
@end;

__attribute__((swift_name("KotlinKDeclarationContainer")))
@protocol SharedKotlinKDeclarationContainer
@required
@end;

__attribute__((swift_name("KotlinKAnnotatedElement")))
@protocol SharedKotlinKAnnotatedElement
@required
@end;

__attribute__((swift_name("KotlinKClassifier")))
@protocol SharedKotlinKClassifier
@required
@end;

__attribute__((swift_name("KotlinKClass")))
@protocol SharedKotlinKClass <SharedKotlinKDeclarationContainer, SharedKotlinKAnnotatedElement, SharedKotlinKClassifier>
@required
- (BOOL)isInstanceValue:(id _Nullable)value __attribute__((swift_name("isInstance(value:)")));
@property (readonly) NSString * _Nullable qualifiedName __attribute__((swift_name("qualifiedName")));
@property (readonly) NSString * _Nullable simpleName __attribute__((swift_name("simpleName")));
@end;

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
