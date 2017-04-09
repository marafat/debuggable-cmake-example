add_library(my-second-native-lib
			STATIC
			NativeSubmodule.cpp)

# add lib dependencies
target_link_libraries(my-second-native-lib
                      GLESv2)