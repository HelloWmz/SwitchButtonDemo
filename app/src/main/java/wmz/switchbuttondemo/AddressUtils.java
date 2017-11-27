package wmz.switchbuttondemo;

import android.content.Context;
import android.view.View;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.OptionsPickerView.OnOptionsSelectListener;
import com.bigkoo.pickerview.lib.WheelView;

import java.util.List;

/**
 * 地址三级联动帮助类
 */
public class AddressUtils {
    /**
     * 底部滚轮点击事件回调
     */
    public interface OnWheelViewClick {
        void onClick(View view, int num);
    }

    /**
     * 弹出底部滚轮选择
     */
    public static void alertBottomWheelOption(Context context, final List<Integer> list, final OnWheelViewClick click) {
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(context, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                click.onClick(v, list.get(options1));
            }
        }).setSubmitText("确定")//确定按钮文字
                .setCancelText("取消")//取消按钮文字
                .setSubCalSize(18)//确定和取消文字大小
                .setContentTextSize(20)
                .setSubCalSize(18)
                .setContentTextSize(20)
                .setCancelColor(0xFFFF7F27)
                .setSubmitColor(0xFFFF7F27)
                .setBgColor(0xFFFFFFFF)
                .setDividerColor(0xFFF8F4EB)
                .setTextColorCenter(0xFFFF7F27)
                .setLinkage(false)//设置是否联动，默认true
                .setCyclic(false, false, false)//循环与否
                .setLineSpacingMultiplier(1.2f)
                .isDialog(false)//是否显示为对话框样式
                .setDividerType(WheelView.DividerType.FILL)
                .build();
        pvOptions.setPicker(list);//添加数据源
        pvOptions.show();
    }
}
