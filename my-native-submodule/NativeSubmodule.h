//
// Created by Muhammad Arafat on 4/3/17.
//

#ifndef DEBUGGABLE_CMAKE_EXAMPLE_NATIVESUBMODULE_H
#define DEBUGGABLE_CMAKE_EXAMPLE_NATIVESUBMODULE_H

#include <string>

std::string getMsgFromNativeSubmodule();

void on_surface_created();
void on_surface_changed(int width, int height);
void on_draw_frame();


#endif //DEBUGGABLE_CMAKE_EXAMPLE_NATIVESUBMODULE_H
