package war;

import java.io.FileDescriptor;
import java.lang.reflect.Field;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

/**
 * Homepage
 */
public class HomePage extends WebPage {
	
	private static final long serialVersionUID = 1L;
	//Variables
	
	private Label label;
	private Label label1;
	private Label label2;
	private TextField  field;
	private TextField  field1;
	private TextField  field2;
	private Button button;
/*
 * 
 * */
    public HomePage(final PageParameters parameters) {
    	//creating new Object (Form)
    	
    	Form form = new Form ("form");
    	
    	//creating new objects field,  field1, field2
    	//textbox 'Name'
    	field = new TextField("field",new Model());
    	form.add(field);
    	
    	//textbox 'surname'
    	field1 = new TextField("field1",new Model());
    	form.add(field1);
    	
    	//textbox 'age'
    	field2 = new TextField("field2",new Model());
    	form.add(field2);
    	
    	//Submit button. It doesn't reload page, just puts values from fields into labels
    	form.add(new  Button("button")
    	{
    		@Override
    		public void onSubmit()
    		{
    			//gets value from textbox 'Name' (using Model)
    			String value = (String)field.getModelObject();
    			label.setModelObject(value);
    			field.setModelObject("");//clear input from textbox
    			
    			//gets value from textbox 'surname' (using Model)
    			String val1 = (String)field1.getModelObject();
    			label1.setModelObject(val1);
    			field1.setModelObject("");
    			
    			//gets value from textbox 'age' (using Model)
    			String val2 = (String)field2.getModelObject();
    			label2.setModelObject(val2);
    			field2.setModelObject("");
    			//
    			String congrats = getString("logerr", null, "Thank You for Information. You've submitted:");
    			error(congrats);
    		}
    	});
    	add(form);
    	add(new Label("message","Please complete the fields below and press 'Submit' button"));
    	add(label = new Label("name",new Model("")));
    	add(label1 = new Label("surname",new Model("")));
    	add(label2 = new Label("age",new Model("")));
    	
    	//Panel 
    	add(new FeedbackPanel("feedback"));
    }
}
