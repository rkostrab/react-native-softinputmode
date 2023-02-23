
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNSoftinputmodeSpec.h"

@interface Softinputmode : NSObject <NativeSoftinputmodeSpec>
#else
#import <React/RCTBridgeModule.h>

@interface Softinputmode : NSObject <RCTBridgeModule>
#endif

@end
