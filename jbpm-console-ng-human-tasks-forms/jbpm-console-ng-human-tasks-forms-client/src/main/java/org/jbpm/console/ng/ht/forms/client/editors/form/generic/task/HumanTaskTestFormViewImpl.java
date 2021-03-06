/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jbpm.console.ng.ht.forms.client.editors.form.generic.task;

import com.github.gwtbootstrap.client.ui.Label;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.jbpm.console.ng.ht.forms.client.i18n.Constants;

import org.uberfire.workbench.events.NotificationEvent;

@Dependent
@Templated(value = "HumanTaskTestFormViewImpl.html")
public class HumanTaskTestFormViewImpl extends Composite implements HumanTaskTestFormPresenter.HumanTaskTestFormView {

  private HumanTaskTestFormPresenter presenter;

  @Inject
  @DataField
  public TextBox taskIdTextBox;
  
  @Inject
  @DataField
  public Label inputTextLabel;
  
  @Inject
  @DataField
  public Label outputTextLabel;

  @Inject
  @DataField
  public TextBox inputTextBox;
  
  @Inject
  @DataField
  public TextBox outputTextBox;

  @Inject
  private Event<NotificationEvent> notification;

  private Constants constants = GWT.create(Constants.class);

  @Override
  public void init(HumanTaskTestFormPresenter presenter) {
    this.presenter = presenter;
    inputTextLabel.setText("Input");
    outputTextLabel.setText("Output");
    taskIdTextBox.setVisible(false);
  }

  @Override
  public void displayNotification(String text) {
    notification.fire(new NotificationEvent(text));
  }

  public TextBox getInputTextBox() {
    return inputTextBox;
  }

  @Override
  public TextBox getTaskIdTextBox() {
    return taskIdTextBox;
  }
  
  @Override
  public TextBox getOutputTextBox() {
    return outputTextBox;
  }

  @Override
  public void setReadOnly(boolean readOnly) {
    if(readOnly){
      inputTextBox.setReadOnly(readOnly);
      outputTextBox.setReadOnly(readOnly);
    }else{
      inputTextBox.setReadOnly(readOnly);
      outputTextBox.setReadOnly(readOnly);
    }
  }
  
  
  
}
