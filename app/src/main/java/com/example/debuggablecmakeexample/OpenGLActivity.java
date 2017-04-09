package com.example.debuggablecmakeexample;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class OpenGLActivity extends AppCompatActivity {

    //region ButterKinfe View Bindings
    /***********************************************/
    // ButterKinfe View Bindings
    /***********************************************/
    Unbinder butterKnifeUnbinder;
    @BindView(R.id.surfaceView_frame) FrameLayout surfaceViewFrameLayout;
    @BindView(R.id.play_button) Button playButton;
    @BindView(R.id.toggle_fullscreen_button) Button toggleFullscreenButton;
    //endregion

    //region Fields
    /***********************************************/
    // Fields
    /***********************************************/
    private GLSurfaceView surfaceView;
    private boolean didSetRenderer = false;
    //endregion


    //region Activity Lifecycle
    /***********************************************/
    // Activity Lifecycle
    /***********************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_gl);
        butterKnifeUnbinder = ButterKnife.bind(this);

        if (!currentDeviceSupportsOpenGLES2()) {
            // this will never happen if the app is downloaded through Google Play,
            // since Play Store filters apps based on Manifest and current device.
            Toast.makeText(this, "This device does not support OpenGL ES v2.0", Toast.LENGTH_LONG)
                    .show();
            return;
        }

        // create and configure GLSurfaceView
        surfaceView = new GLSurfaceView(this);
        surfaceView.setEGLContextClientVersion(2);
        surfaceView.setRenderer(new RendererWrapper());
        didSetRenderer = true;

        // add surface view in its frame
        surfaceViewFrameLayout.addView(surfaceView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (didSetRenderer) {
            surfaceView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (didSetRenderer) {
            surfaceView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        surfaceViewFrameLayout.removeAllViews();
        butterKnifeUnbinder.unbind();
    }
    //endregion


    //region Private Helpers
    /***********************************************/
    // Private Helpers
    /***********************************************/
    private boolean currentDeviceSupportsOpenGLES2() {
        ActivityManager activityManager = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE));
        ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();

        return configurationInfo.reqGlEsVersion >= 0x0002;
    }
    //endregion


    //region Renderer Wrapper
    /***********************************************/
    // Renderer Wrapper
    /***********************************************/
    private class RendererWrapper implements GLSurfaceView.Renderer {

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            GLES20.glClearColor(0.0f, 0.0f, 1.0f, 0.0f);
        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            // nothing yet
        }

        @Override
        public void onDrawFrame(GL10 gl) {
            GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        }
    }
    //endregion

}
