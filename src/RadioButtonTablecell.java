import java.util.HashMap;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class RadioButtonTablecell<S, T> extends TableCell<S, T>

{

	@SuppressWarnings("unchecked")
	protected void updateItem(T item, boolean empty) 
	{
		super.updateItem(item, empty);
		if (!empty) 
		{
			HBox hbox = new HBox(5);
			final ToggleGroup group = new ToggleGroup();
			
			// create a radio button for each 'element' of the enumeration
			
			HashMap<Integer, String> tmp = new HashMap<>();
			tmp.put(-1, "X");
			tmp.put(1, "1");
			tmp.put(0, "0");
			for (int i = 1; i >= -1; i--) 
			{
				RadioButton radioButton = new RadioButton(tmp.get(i));
				radioButton.setUserData(i);
				radioButton.setToggleGroup(group);
				hbox.getChildren().add(radioButton);
				if (i == 0)
				{
					radioButton.setSelected(true);
				}
			}
			
			group.selectedToggleProperty().addListener((e, o, n) ->
			{
				getTableView().edit(getIndex(), getTableColumn());
				commitEdit((T) n.getUserData());
				setGraphic(hbox);
				
			});
			setGraphic(hbox);
		}
	}
}
