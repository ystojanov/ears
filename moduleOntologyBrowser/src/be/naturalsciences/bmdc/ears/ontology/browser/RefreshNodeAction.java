/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.naturalsciences.bmdc.ears.ontology.browser;

import be.naturalsciences.bmdc.ears.ontology.rdf.Refreshable;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;
import org.openide.util.Utilities;
import org.openide.util.actions.CookieAction;
import static org.openide.util.actions.CookieAction.MODE_EXACTLY_ONE;

/*@ActionID(
 category = "Edit",
 id = "com.mit.moview.controler.ExpandNodeAction")
 @ActionRegistration(
 // iconBase = "com/mit/moview/controler/expandIcon.png",
 displayName = "#CTL_ExpandNodeAction")
 @ActionReference(
 path = "Toolbars/ExpCol",
 position = 3330)
 @Messages("CTL_ExpandNodeAction=Expand Node")*/
@ActionID(
        category = "Build",
        id = "be.naturalsciences.bmdc.ears.ontology.browser.RefreshNodeAction")
/*@ActionReferences({
 @ActionReference(path = "Menu/File", position = 0),
 @ActionReference(path = "Loaders/Languages/Actions", position = 0),
 @ActionReference(path = "Projects/Actions")
 })*/
@ActionRegistration(
        displayName = "#CTL_RefreshNodeAction")

@Messages("CTL_RefreshNodeAction=Refresh")

public class RefreshNodeAction extends CookieAction {

    private final Lookup context;
    private Refreshable refreshable;

    public RefreshNodeAction() {
        context = Utilities.actionsGlobalContext();
    }

    @Override
    protected boolean enable(Node[] activatedNodes) {
        if (context.lookup(Refreshable.class) != null) {
            this.refreshable = context.lookup(Refreshable.class);
            return true;
        }
        return false;
    }

    @Override
    protected boolean surviveFocusChange() {
        return false;
    }

    @Override
    protected Class[] cookieClasses() {
        return new Class[]{Refreshable.class};
    }

    @Override
    protected int mode() {
        return MODE_EXACTLY_ONE;
    }

    @Override
    protected void performAction(Node[] activatedNodes) {
        if (refreshable != null) {
            refreshable.refresh();
        }
    }

   /* public void doAction() {
        if (context.lookup(Refreshable.class) != null) {
            this.refreshable = context.lookup(Refreshable.class);
        }

        if (refreshable != null) {
            refreshable.refresh();
        }
    }*/

    @Override
    protected boolean asynchronous() {
        return false;
    }

    @Override
    public String getName() {
        return NbBundle.getMessage(RefreshNodeAction.class, "CTL_RefreshNodeAction");
    }

    @Override
    public HelpCtx getHelpCtx() {
        return new HelpCtx("Halp!");
    }
}
