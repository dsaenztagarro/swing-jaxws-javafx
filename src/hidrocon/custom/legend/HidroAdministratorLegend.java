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
public class HidroAdministratorLegend extends HidroLegend {

	public HidroAdministratorLegend() {
		super();
  		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
		setText(resourceMap.getString("legend.administrator"));
        setIcon("user_executive_red_24x24.png");
	}
}
