/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.custom.legend;

import hidrocon.HidroconView;

/**
 *
 * @author david
 */
public class HidroRateLegend extends HidroLegend {

	public HidroRateLegend() {
		super();
  		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
		setText(resourceMap.getString("legend.rate"));
        setIcon("money_24x24.png");
	}
}
