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
public class HidroBankLegend extends HidroLegend {

	public HidroBankLegend() {
		super();
  		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(hidrocon.HidroconApp.class).getContext().getResourceMap(HidroconView.class);
		setText(resourceMap.getString("legend.databank"));
		setIcon("briefcase_24x24.png");
	}
}
