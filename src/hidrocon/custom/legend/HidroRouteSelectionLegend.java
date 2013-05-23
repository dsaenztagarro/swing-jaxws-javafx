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
public class HidroRouteSelectionLegend extends HidroLegend {

	public HidroRouteSelectionLegend() {
		super();
  		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
		setText(resourceMap.getString("legend.routeselection"));
		setIcon("clipboard_24x24.png");
	}
}
