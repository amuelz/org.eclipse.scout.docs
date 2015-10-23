/*******************************************************************************
 * Copyright (c) 2015 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.html
 *
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package org.eclipsescout.demo.widgets.client.old.ui.forms;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.eclipse.scout.commons.CollectionUtility;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.resource.BinaryResource;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.action.menu.IMenu;
import org.eclipse.scout.rt.client.ui.action.menu.IMenuType;
import org.eclipse.scout.rt.client.ui.action.menu.TableMenuType;
import org.eclipse.scout.rt.client.ui.action.menu.ValueFieldMenuType;
import org.eclipse.scout.rt.client.ui.basic.filechooser.FileChooser;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.ITableRow;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractTimeColumn;
import org.eclipse.scout.rt.client.ui.desktop.OpenUriAction;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCloseButton;
import org.eclipse.scout.rt.client.ui.form.fields.filechooserfield.AbstractFileChooserField;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.tablefield.AbstractTableField;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipsescout.demo.widgets.client.old.ui.forms.FileChooserFieldForm.MainBox.CloseButton;
import org.eclipsescout.demo.widgets.client.old.ui.forms.FileChooserFieldForm.MainBox.FileUploadBox;
import org.eclipsescout.demo.widgets.client.old.ui.forms.FileChooserFieldForm.MainBox.FileUploadBox.FileChooserFieldBox;
import org.eclipsescout.demo.widgets.client.old.ui.forms.FileChooserFieldForm.MainBox.FileUploadBox.FileChooserFieldBox.ChooseAnImageField;
import org.eclipsescout.demo.widgets.client.old.ui.forms.FileChooserFieldForm.MainBox.FileUploadBox.FileDialogBox;
import org.eclipsescout.demo.widgets.client.old.ui.forms.FileChooserFieldForm.MainBox.FileUploadBox.FileDialogBox.UploadMultipleFilesButton;
import org.eclipsescout.demo.widgets.client.old.ui.forms.FileChooserFieldForm.MainBox.FileUploadBox.FileDialogBox.UploadSingleFileButton;
import org.eclipsescout.demo.widgets.client.old.ui.forms.FileChooserFieldForm.MainBox.FileUploadBox.ServerLogBox;
import org.eclipsescout.demo.widgets.client.old.ui.forms.FileChooserFieldForm.MainBox.FileUploadBox.ServerLogBox.ServerLogField;
import org.eclipsescout.demo.widgets.client.ui.forms.IPageForm;

public class FileChooserFieldForm extends AbstractForm implements IPageForm {

  public FileChooserFieldForm() {
    super();
  }

  @Override
  protected boolean getConfiguredAskIfNeedSave() {
    return false;
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("FileChooserField");
  }

  @Override
  public void startPageForm() {
    startInternal(new PageFormHandler());
  }

  public ChooseAnImageField getChooseAnImageField() {
    return getFieldByClass(ChooseAnImageField.class);
  }

  @Override
  public CloseButton getCloseButton() {
    return getFieldByClass(CloseButton.class);
  }

  public FileChooserFieldBox getFileChooserFieldBox() {
    return getFieldByClass(FileChooserFieldBox.class);
  }

  public FileDialogBox getFileDialogBox() {
    return getFieldByClass(FileDialogBox.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public FileUploadBox getFileUploadBox() {
    return getFieldByClass(FileUploadBox.class);
  }

  public ServerLogBox getServerLogBox() {
    return getFieldByClass(ServerLogBox.class);
  }

  public ServerLogField getServerLogField() {
    return getFieldByClass(ServerLogField.class);
  }

  public UploadMultipleFilesButton getUploadMultipleFilesButton() {
    return getFieldByClass(UploadMultipleFilesButton.class);
  }

  public UploadSingleFileButton getUploadSingleFileButton() {
    return getFieldByClass(UploadSingleFileButton.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(10.0)
    public class FileUploadBox extends AbstractGroupBox {

      @Override
      protected int getConfiguredGridColumnCount() {
        return 1;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("FileUpload");
      }

      @Order(10.0)
      public class FileChooserFieldBox extends AbstractGroupBox {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("FileChooserField");
        }

        @Order(20.0)
        public class ChooseAnImageField extends AbstractFileChooserField {

          @Override
          protected List<String> getConfiguredFileExtensions() {
            return CollectionUtility.arrayList("png", "bmp", "jpg", "jpeg", "gif");
          }

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("ChooseAnImage");
          }

          @Override
          protected void execChangedValue() {
            getServerLogField().addLine(getValue());
          }
        }
      }

      @Order(30.0)
      public class FileDialogBox extends AbstractGroupBox {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("FileDialogBox");
        }

        @Order(40.0)
        public class UploadSingleFileButton extends AbstractButton {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("UploadSingleFile");
          }

          @Override
          protected void execClickAction() {
            FileChooser fc = new FileChooser(false);
            List<BinaryResource> files = fc.startChooser();
            for (BinaryResource file : files) {
              getServerLogField().addLine(file);
            }
          }
        }

        @Order(50.0)
        public class UploadMultipleFilesButton extends AbstractButton {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("UploadMultipleFiles");
          }

          @Override
          protected void execClickAction() {
            FileChooser fc = new FileChooser(true);
            List<BinaryResource> files = fc.startChooser();
            for (BinaryResource file : files) {
              getServerLogField().addLine(file);
            }
          }
        }
      }

      @Order(60.0)
      public class ServerLogBox extends AbstractGroupBox {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("ServerLog");
        }

        @Order(1000.0)
        public class ServerLogField extends AbstractTableField<ServerLogField.Table> {

          @Override
          protected int getConfiguredGridH() {
            return 3;
          }

          public void addLine(BinaryResource file) {
            ITableRow row = getTable().addRow(getTable().createRow());
            getTable().getFileColumn().setValue(row, file);
            getTable().getTimeColumn().setValue(row, new Date());
            getTable().getActionColumn().setValue(row, "received " + (file == null ? "no file" : "file: " + file.getFilename()));
            getTable().selectLastRow();
            getTable().scrollToSelection();
          }

          @Override
          protected boolean getConfiguredLabelVisible() {
            return false;
          }

          @Order(70.0)
          public class Table extends AbstractTable {

            @Override
            protected boolean getConfiguredAutoResizeColumns() {
              return true;
            }

            @Override
            protected Class<? extends IMenu> getConfiguredDefaultMenu() {
              return OpenFileMenu.class;
            }

            public FileColumn getFileColumn() {
              return getColumnSet().getColumnByClass(FileColumn.class);
            }

            public TimeColumn getTimeColumn() {
              return getColumnSet().getColumnByClass(TimeColumn.class);
            }

            public ActionColumn getActionColumn() {
              return getColumnSet().getColumnByClass(ActionColumn.class);
            }

            @Order(10.0)
            public class FileColumn extends AbstractColumn<BinaryResource> {

              @Override
              protected boolean getConfiguredDisplayable() {
                return false;
              }
            }

            @Order(20.0)
            public class TimeColumn extends AbstractTimeColumn {

              @Override
              protected String getConfiguredHeaderText() {
                return TEXTS.get("Time");
              }

              @Override
              protected int getConfiguredWidth() {
                return 120;
              }

              @Override
              protected boolean getConfiguredFixedWidth() {
                return true;
              }
            }

            @Order(80.0)
            public class ActionColumn extends AbstractStringColumn {

              @Override
              protected String getConfiguredHeaderText() {
                return TEXTS.get("Action");
              }

              @Override
              protected int getConfiguredWidth() {
                return 120;
              }
            }

            @Order(90.0)
            public class ClearMenu extends AbstractMenu {

              @Override
              protected String getConfiguredText() {
                return TEXTS.get("Clear");
              }

              @Override
              protected void execAction() {
                getTable().deleteAllRows();
              }

              @Override
              protected Set<? extends IMenuType> getConfiguredMenuTypes() {
                return CollectionUtility.<IMenuType> hashSet(TableMenuType.SingleSelection, ValueFieldMenuType.NotNull, TableMenuType.MultiSelection, TableMenuType.EmptySpace);
              }
            }

            @Order(100.0)
            public class OpenFileMenu extends AbstractMenu {

              @Override
              protected String getConfiguredText() {
                return "Download file";
              }

              @Override
              protected Set<? extends IMenuType> getConfiguredMenuTypes() {
                return CollectionUtility.<IMenuType> hashSet(TableMenuType.SingleSelection);
              }

              @Override
              protected void execOwnerValueChanged(Object newOwnerValue) {
                setVisible(getFileColumn().getSelectedValue() != null);
              }

              @Override
              protected void execAction() {
                getDesktop().openUri(getFileColumn().getSelectedValue(), OpenUriAction.DOWNLOAD);
              }
            }
          }
        }
      }
    }

    @Order(180.0)
    public class CloseButton extends AbstractCloseButton {
    }
  }

  public class PageFormHandler extends AbstractFormHandler {
  }
}
