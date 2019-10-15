// Generated code from Butter Knife. Do not modify!
package com.xacheliangroup.netline.checkTickets.mvp.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xacheliangroup.netline.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CTCarListView_ViewBinding implements Unbinder {
  private CTCarListView target;

  @UiThread
  public CTCarListView_ViewBinding(CTCarListView target, View source) {
    this.target = target;

    target.mBottomLy = Utils.findRequiredViewAsType(source, R.id.module_ct_item_car_list_bottom_ly, "field 'mBottomLy'", LinearLayout.class);
    target.mCarTrainTx = Utils.findRequiredViewAsType(source, R.id.item_car_no_tx, "field 'mCarTrainTx'", TextView.class);
    target.mCarDataTx = Utils.findRequiredViewAsType(source, R.id.item_car_time_tx, "field 'mCarDataTx'", TextView.class);
    target.mCarTypeTx = Utils.findRequiredViewAsType(source, R.id.item_car_type_tx, "field 'mCarTypeTx'", TextView.class);
    target.mCarStartStationTx = Utils.findRequiredViewAsType(source, R.id.item_car_start_tx, "field 'mCarStartStationTx'", TextView.class);
    target.mUpCarTimeTx = Utils.findRequiredViewAsType(source, R.id.item_car_start_time_tx, "field 'mUpCarTimeTx'", TextView.class);
    target.mCarEndStationTx = Utils.findRequiredViewAsType(source, R.id.item_car_end_tx, "field 'mCarEndStationTx'", TextView.class);
    target.mCarStartLocationTx = Utils.findRequiredViewAsType(source, R.id.item_car_start_location_tx, "field 'mCarStartLocationTx'", TextView.class);
    target.mCarEndLocationTx = Utils.findRequiredViewAsType(source, R.id.item_car_end_location_tx, "field 'mCarEndLocationTx'", TextView.class);
    target.mCarNoTx = Utils.findRequiredViewAsType(source, R.id.item_car_car_no_tx, "field 'mCarNoTx'", TextView.class);
    target.mCarCompanyTx = Utils.findRequiredViewAsType(source, R.id.item_car_car_company_tx, "field 'mCarCompanyTx'", TextView.class);
    target.mSellNumberTX = Utils.findRequiredViewAsType(source, R.id.item_car_sell_number_tx, "field 'mSellNumberTX'", TextView.class);
    target.mCheckNumberTx = Utils.findRequiredViewAsType(source, R.id.item_car_check_number_tx, "field 'mCheckNumberTx'", TextView.class);
    target.mOverNumberTx = Utils.findRequiredViewAsType(source, R.id.item_car_over_number_tx, "field 'mOverNumberTx'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CTCarListView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBottomLy = null;
    target.mCarTrainTx = null;
    target.mCarDataTx = null;
    target.mCarTypeTx = null;
    target.mCarStartStationTx = null;
    target.mUpCarTimeTx = null;
    target.mCarEndStationTx = null;
    target.mCarStartLocationTx = null;
    target.mCarEndLocationTx = null;
    target.mCarNoTx = null;
    target.mCarCompanyTx = null;
    target.mSellNumberTX = null;
    target.mCheckNumberTx = null;
    target.mOverNumberTx = null;
  }
}
