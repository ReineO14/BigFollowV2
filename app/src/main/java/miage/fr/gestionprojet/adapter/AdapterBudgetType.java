package miage.fr.gestionprojet.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import miage.fr.gestionprojet.R;
import miage.fr.gestionprojet.models.dao.DaoAction;
import miage.fr.gestionprojet.outils.Outils;
import miage.fr.gestionprojet.vues.ActivityBudget;

/**
 * Created by Audrey on 25/04/2017.
 */

public class AdapterBudgetType extends AbstractAdapterBudget<String> {

    public AdapterBudgetType(ActivityBudget context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @Override
    protected void chargerNbAction() {
        setLstNbActions(new ArrayList<Integer>());
        setLstNbActionsRealisees(new ArrayList<Integer>());
        HashMap<String, Integer> results = DaoAction.getBudgetTotalByActionRealiseeGroupByTypeTravail();

        if (results.size() > 0) {
            for (String t : getListBudget()) {
                if (results.get(t) != null) {
                    addActionsRealisees(results.get(t));
                } else {
                    addActionsRealisees(0);
                }
            }

        }

        results = DaoAction.getBudgetTotalByActionTotalGroupByTypeTravail();
        if (results.size() > 0) {
            for (String t : getListBudget()) {
                if (results.get(t) != null) {
                    addActions(results.get(t));
                } else {
                    addActions(0);
                }
            }

        }
    }

}
