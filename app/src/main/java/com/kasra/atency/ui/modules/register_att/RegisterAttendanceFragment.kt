package com.kasra.atency.ui.modules.register_att

import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.drawable.PaintDrawable
import android.graphics.drawable.ShapeDrawable.ShaderFactory
import android.graphics.drawable.shapes.RectShape
import android.os.Bundle
import android.provider.Settings
import android.provider.Settings.SettingNotFoundException
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.content.res.AppCompatResources
import com.example.bilerplatemvvm.R
import com.kasra.atency.ui.base.BaseFragment
import com.mapbox.mapboxsdk.Mapbox
import io.sentry.Sentry
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class RegisterAttendanceFragment:BaseFragment(R.layout.fragment_home) {
    lateinit var paintDrawble: PaintDrawable
    lateinit var shaderFactory : ShaderFactory
    var seekBarEnable = true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Mapbox.getInstance(
            requireContext(),
            "sk.eyJ1IjoiYWRlbC1kZHI1MSIsImEiOiJja29zYzl0NjEwMDQ2MnhxajFpb29jMTEyIn0.R1EN9I8EMTM3XpXxJU-Qqw"
        )
        paintDrawble = PaintDrawable()
        paintDrawble.shape = RectShape()
        initSeekBar()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(
            requireContext(),
            "sk.eyJ1IjoiYWRlbC1kZHI1MSIsImEiOiJja29zYzl0NjEwMDQ2MnhxajFpb29jMTEyIn0.R1EN9I8EMTM3XpXxJU-Qqw"
        )

    }
    fun onFailure(exception: Exception) {
        Mapbox.getInstance(
            requireContext(),
            "sk.eyJ1IjoiYWRlbC1kZHI1MSIsImEiOiJja29zYzl0NjEwMDQ2MnhxajFpb29jMTEyIn0.R1EN9I8EMTM3XpXxJU-Qqw"
        )
    }

    override fun onStart() {
        super.onStart()
        Mapbox.getInstance(
            requireContext(),
            "sk.eyJ1IjoiYWRlbC1kZHI1MSIsImEiOiJja29zYzl0NjEwMDQ2MnhxajFpb29jMTEyIn0.R1EN9I8EMTM3XpXxJU-Qqw"
        )
        map_home.onStart()
    }

    override fun onResume() {
        super.onResume()
        Mapbox.getInstance(
            requireContext(),
            "sk.eyJ1IjoiYWRlbC1kZHI1MSIsImEiOiJja29zYzl0NjEwMDQ2MnhxajFpb29jMTEyIn0.R1EN9I8EMTM3XpXxJU-Qqw"
        )
        map_home.onResume()
    }

    override fun onPause() {
        super.onPause()
        Mapbox.getInstance(
            requireContext(),
            "sk.eyJ1IjoiYWRlbC1kZHI1MSIsImEiOiJja29zYzl0NjEwMDQ2MnhxajFpb29jMTEyIn0.R1EN9I8EMTM3XpXxJU-Qqw"
        )
        map_home.onPause()
    }

    override fun onStop() {
        super.onStop()
        Mapbox.getInstance(
            requireContext(),
            "sk.eyJ1IjoiYWRlbC1kZHI1MSIsImEiOiJja29zYzl0NjEwMDQ2MnhxajFpb29jMTEyIn0.R1EN9I8EMTM3XpXxJU-Qqw"
        )
        map_home.onStop()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Mapbox.getInstance(
            requireContext(),
            "sk.eyJ1IjoiYWRlbC1kZHI1MSIsImEiOiJja29zYzl0NjEwMDQ2MnhxajFpb29jMTEyIn0.R1EN9I8EMTM3XpXxJU-Qqw"
        )
        map_home.onCreate(savedInstanceState)
    }
    private fun initSeekBar() {
//        enableOrDisableSeekBarBackground(false)
        seekBar.thumb = AppCompatResources.getDrawable(requireContext(), R.drawable.switch_circle)
        seekBar.max = 200
        seekBar.progress = 100
        seekBar.background = paintDrawble
        seekBar.isEnabled = false
        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (seekBarEnable) {
                    shaderFactory = object : ShaderFactory() {
                        override fun resize(width: Int, height: Int): Shader {
                            return LinearGradient(
                                0.0f,
                                0.0f,
                                width.toFloat(),
                                height.toFloat(),
                                intArrayOf(-0x43cbd0, -0x9bca95, -0xfbc953),
                                floatArrayOf(0f, 1 - progress.toFloat() / 200, 1f),
                                Shader.TileMode.CLAMP
                            )
                        }
                    }
                } else {
                    shaderFactory = object : ShaderFactory() {
                        override fun resize(width: Int, height: Int): Shader {
                            return LinearGradient(
                                0.0f,
                                0.0f,
                                width.toFloat(),
                                height.toFloat(),
                                intArrayOf(-0x6e6e6f, -0x6e6e6f),
                                floatArrayOf(0f, 1f),
                                Shader.TileMode.CLAMP
                            )
                        }
                    }
                }
                paintDrawble.setShaderFactory(shaderFactory)
                paintDrawble.setCornerRadius(200f)
                seekBar.background = paintDrawble
                if (seekBar.progress > 160) {
//                    enterTxt.setText("")
                } else {
//                    enterTxt.setText(context!!.resources.getString(R.string.enter))
                }
                if (seekBar.progress < 40) {
//                    exitTxt.setText("")
                } else {
//                    exitTxt.setText(context!!.resources.getString(R.string.exit))
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //nothing
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                try {
                    val timeSetting = Settings.Global.getInt(
                        Objects.requireNonNull(activity)?.contentResolver, Settings.Global.AUTO_TIME
                    )
                    val timeZoneSetting = Settings.Global.getInt(
                        activity!!.contentResolver, Settings.Global.AUTO_TIME_ZONE
                    )
                    if (timeSetting == 1 && timeZoneSetting == 1) {
                        //It is Exit
                        if (seekBar.progress <= 25) {
                            seekBar.progress = 100
//                            personWorkplaceModel = null
//                            addAttendance = true
//                            isEnter = false
//                            checkBle()
                        } else {
//                            seekBarInMiddleEarth()
                        }
                        if (seekBar.progress > 175) {
                            seekBar.progress = 100
                            //                            showProgress();
//                            personWorkplaceModel = null
//                            isEnter = true
//                            addAttendance = true
//                            checkBle()
                        } else {
//                            seekBarInMiddleEarth()
                        }
                    } else {
                        showErrorMessage(getString(R.string.fake_time))
//                        seekBarInMiddleEarth()
                    }
                } catch (e: SettingNotFoundException) {
                    Sentry.captureException(e)
                }
            }
        })
    }

}