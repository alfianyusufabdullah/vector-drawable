package alfianyusufabdullah.vector

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {

    companion object {
        fun createdInstance(res: Int): MainFragment {

            val bundle = Bundle()
            bundle.putInt("RES", res)

            val mainFragment = MainFragment()
            mainFragment.arguments = bundle
            return mainFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iv_preview.setImageResource(arguments?.getInt("RES") ?: R.drawable.dicoding_drawable)

        sk_size.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                val size = 80 * p1

                iv_preview.layoutParams.height = size
                iv_preview.layoutParams.width = size
                iv_preview.requestLayout()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })
    }
}
