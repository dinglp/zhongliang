package com.wanhe.zhongliang.view;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.wanhe.zhongliang.R;
/**
 * Created by youtl on 2016/1/23.
 */
public class DialogManager implements View.OnClickListener {

    private Dialog dialog;
    private static DialogManager mDialogManager;
    private Activity mActivity;

    private DialogManager() {
    }

    public static DialogManager getInstance() {
        if (mDialogManager == null) {
            synchronized (DialogManager.class) {
                if (mDialogManager == null) {
                    mDialogManager = new DialogManager();
                }
            }
        }
        return mDialogManager;
    }

//    /**
//     * 从相册获取照片的dialog
//     *
//     * @param ac
//     * @param listener
//     */
//    public void showAddPicDialog(Activity ac, View.OnClickListener listener) {
//        mActivity = ac;
//        dialog = new FullScreenWidthDialog(mActivity, R.style.myDialogStyle);
//        Window window = dialog.getWindow();
//        window.requestFeature(Window.FEATURE_NO_TITLE);
//        View view = ac.getLayoutInflater().inflate(R.layout.layout_dialog_addpic, null, false);
//        dialog.setContentView(view);
//        window.setGravity(Gravity.BOTTOM);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
//        Button btn_upload = (Button) view.findViewById(R.id.btn_upload);
//        Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
//        btn_upload.setOnClickListener(listener);
//        btn_cancel.setOnClickListener(this);
//    }
//
//    /**
//     * 从云相册获取照片的dialog
//     *
//     * @param ac
//     * @param listener
//     */
//    public void showAddCloudPicDialog(Activity ac, View.OnClickListener listener) {
//        mActivity = ac;
//        dialog = new FullScreenWidthDialog(mActivity, R.style.myDialogStyle);
//        Window window = dialog.getWindow();
//        window.requestFeature(Window.FEATURE_NO_TITLE);
//        View view = ac.getLayoutInflater().inflate(R.layout.layout_dialog_add_cloudpic, null, false);
//        dialog.setContentView(view);
//        window.setGravity(Gravity.BOTTOM);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
//        Button btn_promt = (Button) view.findViewById(R.id.btn_promt);
//        Button btn_cloud_gallery = (Button) view.findViewById(R.id.btn_cloud_gallery);
//        Button btn_gallery = (Button) view.findViewById(R.id.btn_gallery);
//        Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
//        btn_promt.setOnClickListener(listener);
//        btn_cloud_gallery.setOnClickListener(listener);
//        btn_gallery.setOnClickListener(listener);
//        btn_cancel.setOnClickListener(this);
//    }
//    /**
//     * 删除，取消的dialog
//     */
//    public void deleteShowDialog(Activity ac, View.OnClickListener listener) {
//        mActivity = ac;
//        dialog = new FullScreenWidthDialog(mActivity, R.style.myDialogStyle);
//        Window window = dialog.getWindow();
//        window.requestFeature(Window.FEATURE_NO_TITLE);
//        View view = ac.getLayoutInflater().inflate(R.layout.layout_dialog_delete, null, false);
//        dialog.setContentView(view);
//        window.setGravity(Gravity.BOTTOM);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
//        Button btn_delete = (Button) view.findViewById(R.id.btn_delete);
//        Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
//        btn_delete.setOnClickListener(listener);
//        btn_cancel.setOnClickListener(this);
//    }
//
//    /**
//     * 修改 删除，取消的dialog
//     */
//    public void modifyDeleteShowDialog(Activity ac, View.OnClickListener listener) {
//        mActivity = ac;
//        dialog = new FullScreenWidthDialog(mActivity, R.style.myDialogStyle);
//        Window window = dialog.getWindow();
//        window.requestFeature(Window.FEATURE_NO_TITLE);
//        View view = ac.getLayoutInflater().inflate(R.layout.layout_dialog_modify_delete, null, false);
//        dialog.setContentView(view);
//        window.setGravity(Gravity.BOTTOM);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
//        Button btn_modify = (Button) view.findViewById(R.id.btn_modify);
//        Button btn_delete = (Button) view.findViewById(R.id.btn_delete);
//        Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
//        btn_modify.setOnClickListener(listener);
//        btn_delete.setOnClickListener(listener);
//        btn_cancel.setOnClickListener(this);
//    }
//
    /**
     * 从相册和相机获取照片的dialog
     */
    public void showAddPicFromCameraAndGalleryDialog(Activity ac, View.OnClickListener listener) {
        mActivity = ac;
        dialog = new FullScreenWidthDialog(mActivity, R.style.myDialogStyle);
        Window window = dialog.getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        View view = ac.getLayoutInflater().inflate(R.layout.layout_dialog_addpic_from_cameraandgallery, null, false);
        dialog.setContentView(view);
        window.setGravity(Gravity.BOTTOM);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        Button btn_camera = (Button) view.findViewById(R.id.btn_camera);
        Button btn_gallery = (Button) view.findViewById(R.id.btn_gallery);
        Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
        btn_camera.setOnClickListener(listener);
        btn_gallery.setOnClickListener(listener);
        btn_cancel.setOnClickListener(this);
    }
//
//    /**
//     * 添加视频或者照片
//     */
//    public void showAddVideoOrPicture(Activity ac, View.OnClickListener listener) {
//        mActivity = ac;
//        dialog = new FullScreenWidthDialog(mActivity, R.style.myDialogStyle);
//        Window window = dialog.getWindow();
//        window.requestFeature(Window.FEATURE_NO_TITLE);
//        View view = ac.getLayoutInflater().inflate(R.layout.dialog_addvideo_picture, null, false);
//        dialog.setContentView(view);
//        window.setGravity(Gravity.BOTTOM);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
//        Button btn_add_video = (Button) view.findViewById(R.id.btn_add_video);
//        Button btn_add_picture = (Button) view.findViewById(R.id.btn_add_picture);
//        Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
//        btn_add_video.setOnClickListener(listener);
//        btn_add_picture.setOnClickListener(listener);
//        btn_cancel.setOnClickListener(this);
//    }
//
//    /**
//     * 举报或者回复别人的评论
//     */
//    public void showReportAndReply(Activity ac, View.OnClickListener listener) {
//        mActivity = ac;
//        dialog = new FullScreenWidthDialog(mActivity, R.style.myDialogStyle);
//        Window window = dialog.getWindow();
//        window.requestFeature(Window.FEATURE_NO_TITLE);
//        View view = ac.getLayoutInflater().inflate(R.layout.dialog_report_and_reply, null, false);
//        dialog.setContentView(view);
//        window.setGravity(Gravity.BOTTOM);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
//        Button btn_reply = (Button) view.findViewById(R.id.btn_reply);
//        Button btn_report = (Button) view.findViewById(R.id.btn_report);
//        Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
//        btn_reply.setOnClickListener(listener);
//        btn_report.setOnClickListener(listener);
//        btn_cancel.setOnClickListener(this);
//    }
//    /**
//     * 保存放大后的照片到本地相册
//     */
//    public void saveBigImage(Activity ac, View.OnClickListener listener) {
//        mActivity = ac;
//        dialog = new FullScreenWidthDialog(mActivity, R.style.myDialogStyle);
//        Window window = dialog.getWindow();
//        window.requestFeature(Window.FEATURE_NO_TITLE);
//        View view = ac.getLayoutInflater().inflate(R.layout.dialog_show_big_img, null, false);
//        dialog.setContentView(view);
//        window.setGravity(Gravity.BOTTOM);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();
//        Button btn_save_big_img = (Button) view.findViewById(R.id.btn_save_big_img);
//        Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
//        btn_save_big_img.setOnClickListener(listener);
//        btn_cancel.setOnClickListener(this);
//    }

//
///**分享**/
//public void circleShare(Activity ac, View.OnClickListener listener, int flag){
//    mActivity = ac;
//    dialog = new FullScreenWidthDialog(mActivity, R.style.myDialogStyle);
//    Window window = dialog.getWindow();
//    window.requestFeature(Window.FEATURE_NO_TITLE);
//    View view = ac.getLayoutInflater().inflate(R.layout.pop_share, null, false);
//    View view1 = view.findViewById(R.id.jubaoxian);
//    LinearLayout ll = (LinearLayout) view.findViewById(R.id.jubao);
//    if (flag == 2) {
//        ll.setVisibility(View.GONE);
//        view1.setVisibility(View.GONE);
//    }
//    dialog.setContentView(view);
//    window.setGravity(Gravity.BOTTOM);
//    dialog.setCanceledOnTouchOutside(true);
//    dialog.show();
//    TextView pop_cancel = (TextView) view.findViewById(R.id.pop_cancel);
//    TextView fuzhi_text = (TextView) view.findViewById(R.id.fuzhi_text);
//    TextView jubao_text = (TextView) view.findViewById(R.id.jubao_text);
//    TextView zhuye_text = (TextView) view.findViewById(R.id.zhuye_text);
//    ImageButton weixin_frient = (ImageButton) view.findViewById(R.id
//            .weixin_frient);
//    ImageButton weixin_zone = (ImageButton) view.findViewById(R.id.weixin_zone);
//    ImageButton qq_frient = (ImageButton) view.findViewById(R.id.qq_frient);
//    ImageButton qq_zone = (ImageButton) view.findViewById(R.id.qq_zone);
//    ImageButton weibo = (ImageButton) view.findViewById(R.id.weibo);
//    ImageButton copy = (ImageButton) view.findViewById(R.id.copy);
//    ImageButton jubao = (ImageButton) view.findViewById(R.id.jubao_bt);
//    ImageButton zhuye = (ImageButton) view.findViewById(R.id.zhuye);
//    weixin_frient.setOnClickListener(listener);
//    weixin_zone.setOnClickListener(listener);
//    qq_frient.setOnClickListener(listener);
//    qq_zone.setOnClickListener(listener);
//    weibo.setOnClickListener(listener);
//    copy.setOnClickListener(listener);
//    jubao.setOnClickListener(listener);
//    zhuye.setOnClickListener(listener);
//    fuzhi_text.setOnClickListener(listener);
//    jubao_text.setOnClickListener(listener);
//    zhuye_text.setOnClickListener(listener);
//    pop_cancel.setOnClickListener(this);
//}
    @Override
    public void onClick(View v) {
        disMissDialog();
    }

    public void disMissDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
