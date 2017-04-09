#include "NativeSubmodule.h"
#include <GLES2/gl2.h>

std::string getMsgFromNativeSubmodule() {
    std::string msg = "\nHello From Native Sub-module";
    return msg;
}

void on_surface_created() {
    glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
}

void on_surface_changed(int width, int height) {
    // nothing yet
}

void on_draw_frame() {
    glClear(GL_COLOR_BUFFER_BIT);
}
