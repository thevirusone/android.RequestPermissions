package io.github.yamacraft.requestpermissions;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;
import timber.log.Timber;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnClick(R.id.calendar_button)
    protected void onClickCalendarButton() {
        MainActivityPermissionsDispatcher.needsPermissionReadCalendarWithCheck(this);
    }

    @OnClick(R.id.camera_button)
    protected void onClickCameraButton() {
        MainActivityPermissionsDispatcher.needsPermissionCameraWithCheck(this);
    }

    @OnClick(R.id.contacts_button)
    protected void onClickContactsButton() {
        MainActivityPermissionsDispatcher.needsPermissionGetAccountsWithCheck(this);
    }

    @OnClick(R.id.location_button)
    protected void onClickLocationButton() {
        MainActivityPermissionsDispatcher.needsPermissionAccessFineLocationWithCheck(this);
    }

    @OnClick(R.id.microphone_button)
    protected void onClickMicrophoneButton() {
        MainActivityPermissionsDispatcher.needsPermissionRecordAudioWithCheck(this);
    }

    @OnClick(R.id.phone_button)
    protected void onClickPhoneButton() {
        MainActivityPermissionsDispatcher.needsPermissionReadCallLogWithCheck(this);
    }

    @OnClick(R.id.sensors_button)
    protected void onClickSensorsButton() {
        MainActivityPermissionsDispatcher.needsPermissionBodySensorsWithCheck(this);
    }

    @OnClick(R.id.sms_button)
    protected void onClickSmsButton() {
        MainActivityPermissionsDispatcher.needsPermissionSendSmsWithCheck(this);
        Timber.i("Click To Sms");
    }

    @OnClick(R.id.storage_button)
    protected void onClickStorageButton() {
        MainActivityPermissionsDispatcher.needsPermissionReadExternalStoragesWithCheck(this);
    }


    @NeedsPermission(Manifest.permission.READ_CALENDAR)
    protected void needsPermissionReadCalendar() {
        Toast.makeText(this, "許可されています。", Toast.LENGTH_SHORT).show();
    }

    @NeedsPermission(Manifest.permission.CAMERA)
    protected void needsPermissionCamera() {
        Toast.makeText(this, "許可されています。", Toast.LENGTH_SHORT).show();
    }

    @NeedsPermission(Manifest.permission.GET_ACCOUNTS)
    protected void needsPermissionGetAccounts() {
        Toast.makeText(this, "許可されています。", Toast.LENGTH_SHORT).show();
    }

    @NeedsPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    protected void needsPermissionAccessFineLocation() {
        Toast.makeText(this, "許可されています。", Toast.LENGTH_SHORT).show();
    }

    @NeedsPermission(Manifest.permission.RECORD_AUDIO)
    protected void needsPermissionRecordAudio() {
        Toast.makeText(this, "許可されています。", Toast.LENGTH_SHORT).show();
    }

    @NeedsPermission(Manifest.permission.READ_CALL_LOG)
    protected void needsPermissionReadCallLog() {
        Toast.makeText(this, "許可されています。", Toast.LENGTH_SHORT).show();
    }

    @NeedsPermission(Manifest.permission.BODY_SENSORS)
    protected void needsPermissionBodySensors() {
        Toast.makeText(this, "許可されています。", Toast.LENGTH_SHORT).show();
    }

    @NeedsPermission(Manifest.permission.RECEIVE_WAP_PUSH)
    protected void needsPermissionSendSms() {
        Toast.makeText(this, "許可されています。", Toast.LENGTH_SHORT).show();
    }

    @NeedsPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
    protected void needsPermissionReadExternalStorages() {
        Toast.makeText(this, "許可されています。", Toast.LENGTH_SHORT).show();
    }
}
