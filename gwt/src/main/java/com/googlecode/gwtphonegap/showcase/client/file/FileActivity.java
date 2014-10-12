package com.googlecode.gwtphonegap.showcase.client.file;

import java.util.ArrayList;
import java.util.LinkedList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.file.DirectoryEntry;
import com.googlecode.gwtphonegap.client.file.DirectoryReader;
import com.googlecode.gwtphonegap.client.file.EntryBase;
import com.googlecode.gwtphonegap.client.file.FileCallback;
import com.googlecode.gwtphonegap.client.file.FileEntry;
import com.googlecode.gwtphonegap.client.file.FileError;
import com.googlecode.gwtphonegap.client.file.FileObject;
import com.googlecode.gwtphonegap.client.file.FileReader;
import com.googlecode.gwtphonegap.client.file.FileSystem;
import com.googlecode.gwtphonegap.client.file.FileWriter;
import com.googlecode.gwtphonegap.client.file.Flags;
import com.googlecode.gwtphonegap.client.file.ReaderCallback;
import com.googlecode.gwtphonegap.client.file.WriterCallback;
import com.googlecode.gwtphonegap.collection.shared.LightArray;
import com.googlecode.gwtphonegap.showcase.client.BasicCell;
import com.googlecode.gwtphonegap.showcase.client.ClientFactory;
import com.googlecode.gwtphonegap.showcase.client.OverviewPlace;
import com.googlecode.gwtphonegap.showcase.client.model.FileDemo;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.button.ButtonBase;
import com.googlecode.mgwt.ui.client.widget.dialog.Dialogs;
import com.googlecode.mgwt.ui.client.widget.dialog.Dialogs.ButtonType;
import com.googlecode.mgwt.ui.client.widget.dialog.Dialogs.OptionCallback;
import com.googlecode.mgwt.ui.client.widget.dialog.Dialogs.OptionsDialogEntry;
import com.googlecode.mgwt.ui.client.widget.input.MTextArea;
import com.googlecode.mgwt.ui.client.widget.list.celllist.CellList;
import com.googlecode.mgwt.ui.client.widget.list.celllist.CellSelectedEvent;

public class FileActivity extends MGWTAbstractActivity {

  public static class MyPlace extends Place {
    public static class Tokenizer implements PlaceTokenizer<MyPlace> {

      @Override
      public MyPlace getPlace(String token) {
        return new MyPlace();
      }
      @Override
      public String getToken(MyPlace place) {
        return null;
      }
    }
  }

  private static Binder BINDER = GWT.create(Binder.class);
  interface Binder extends UiBinder<Widget, FileActivity> {}

  private PhoneGap phoneGap;
  private LightArray<EntryBase> currentEntries;
  private DirectoryEntry currentDir;
  private FileEntry currentFile;
  private Widget rootWidget;
  private PlaceController placeController;

  @UiField(provided = true)
  CellList<FileDemo> cellList;

  @UiField
  ButtonBase plusButton;

  @UiField
  ButtonBase actionButton;

  @UiField
  HTML status;

  @UiField
  MTextArea content;

  public FileActivity(ClientFactory clientFactory) {

    BasicCell<FileDemo> cell = new BasicCell<FileDemo>() {

      @Override
      public String getDisplayString(FileDemo model) {
        return model.getName();
      }
      @Override
      public boolean canBeSelected(FileDemo model) {
        return true;
      }
    };

    cellList = new CellList<FileDemo>(cell);

    placeController = clientFactory.getPlaceController();
    rootWidget = BINDER.createAndBindUi(this);
    this.phoneGap = clientFactory.getPhoneGap();

    phoneGap.getFile().requestFileSystem(FileSystem.LocalFileSystem_PERSISTENT,
        0, new FileCallback<FileSystem, FileError>() {

          @Override
          public void onSuccess(FileSystem entry) {
            gotFileSystem(entry);
          }
          @Override
          public void onFailure(FileError error) {
            status.setHTML("Failed to request file system with error code: "
                + error.getErrorCode());
          }
        });
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    panel.setWidget(rootWidget);
  }

  private void gotFileSystem(FileSystem fileSystem) {
    listDirectory(fileSystem.getRoot());
  }

  private void listDirectory(final DirectoryEntry directoryEntry) {
    currentDir = directoryEntry;

    status.setHTML("Listing '" + directoryEntry.getName() + "");
    DirectoryReader directoryReader = directoryEntry.createReader();

    directoryReader.readEntries(new FileCallback<LightArray<EntryBase>, FileError>() {

      @Override
      public void onSuccess(LightArray<EntryBase> entries) {
        currentEntries = entries;
        status.setHTML("Directory '" + directoryEntry.getFullPath() + "'");

        LinkedList<FileDemo> list = new LinkedList<FileDemo>();
        list.add(new FileDemo("../"));

        for (int i = 0; i < entries.length(); i++) {
          EntryBase entryBase = entries.get(i);
          String name;

          if (entryBase.isDirectory()) {
            DirectoryEntry directoryEntry = entryBase.getAsDirectoryEntry();
            name = directoryEntry.getName();
          } else {
            FileEntry fileEntry = entryBase.getAsFileEntry();
            name = fileEntry.getName();
          }
          list.add(new FileDemo(name));
        }
        render(list);
      }

      @Override
      public void onFailure(FileError error) {
        status.setHTML("Error while listing '" + directoryEntry.getFullPath() + "'");
      }
    });
  }

  public void createFile(String fileName) {
    if (currentDir != null) {

      currentDir.getFile(fileName, new Flags(true, false),
          new FileCallback<FileEntry, FileError>() {

            @Override
            public void onSuccess(FileEntry entry) {
              listDirectory(currentDir);
            }

            @Override
            public void onFailure(FileError error) {
              Window.alert("error");

            }
          });
    }
  }

  @UiHandler("actionButton")
  public void onActionButtonPressed(TapEvent event) {
    showSelectMenu();
  }

  public void overWriteFile() {
    if (confirm("Really rewrite file?")) {
      if (currentFile != null) {
        currentFile.createWriter(new FileCallback<FileWriter, FileError>() {

          @Override
          public void onSuccess(FileWriter entry) {
            entry.setOnWriteEndCallback(new WriterCallback<FileWriter>() {

              @Override
              public void onCallback(FileWriter result) {
                Window.alert("file written");
              }
            });

            entry.setOnErrorCallback(new WriterCallback<FileWriter>() {

              @Override
              public void onCallback(FileWriter result) {
                Window.alert("error while writing file");
              }
            });
            entry.write(getFileContent().getText());
          }

          @Override
          public void onFailure(FileError error) {
            Window.alert("can not create writer");
          }
        });
      }
    }
  }

  public void onEntrySelected(CellSelectedEvent event) {
    int index = event.getIndex();
    if (index == 0) {
      if (currentDir != null) {
        currentDir.getParent(new FileCallback<DirectoryEntry, FileError>() {

          @Override
          public void onSuccess(DirectoryEntry entry) {
            listDirectory(entry);
          }

          @Override
          public void onFailure(FileError error) {
            Window.alert("error und so !!!!!!!!");
          }
        });
      }
      getFileContent().setText("");
      return;
    }
    index = index - 1;
    EntryBase entryBase = currentEntries.get(index);

    if (entryBase.isDirectory()) {
      DirectoryEntry directoryEntry = entryBase.getAsDirectoryEntry();
      listDirectory(directoryEntry);
      getFileContent().setText("");
      return;
    }

    if (entryBase.isFile()) {
      final FileEntry fileEntry = entryBase.getAsFileEntry();
      fileEntry.getFile(new FileCallback<FileObject, FileError>() {

        @Override
        public void onSuccess(FileObject fileObject) {
          readFile(fileEntry, fileObject);
        }

        @Override
        public void onFailure(FileError error) {
          Window.alert("Can not get FileObject");
        }
      });

      setSelected(index + 1);
      return;
    }
  }

  public void render(LinkedList<FileDemo> list) {
    cellList.render(list);
  }

  @UiHandler("backButton")
  protected void oBackButtonPressed(TapEvent event) {
    placeController.goTo(new OverviewPlace());
  }

  @UiHandler("plusButton")
  protected void onPlusButtonTapped(TapEvent event) {
    String fileName = Window.prompt("filename", "");
    createFile(fileName);
  }

  public void showSelectMenu() {
    ArrayList<OptionsDialogEntry> list = new ArrayList<OptionsDialogEntry>();

    list.add(new OptionsDialogEntry("Overwrite", ButtonType.IMPORTANT));
    list.add(new OptionsDialogEntry("Cancel", ButtonType.NORMAL));

    Dialogs.options(list, new OptionCallback() {

      @Override
      public void onOptionSelected(int index) {
        overWriteFile();
      }
    });
  }

  public boolean confirm(String string) {
    return Window.confirm(string);
  }

  public HasText getFileContent() {
    return new HasText() {

      @Override
      public void setText(String text) {
        content.setText(text);

      }

      @Override
      public String getText() {
        return content.getText();
      }
    };
  }

  public void setSelected(int index) {
    cellList.setSelectedIndex(index, true);
  }

  private void readFile(final FileEntry entry, final FileObject fileObject) {
    FileReader reader = phoneGap.getFile().createReader();
    reader.setOnloadCallback(new ReaderCallback<FileReader>() {

      @Override
      public void onCallback(FileReader result) {

        getFileContent().setText(result.getResult());
        currentFile = entry;
      }
    });

    reader.setOnErrorCallback(new ReaderCallback<FileReader>() {

      @Override
      public void onCallback(FileReader result) {
        getFileContent().setText("Error while reading file");
      }
    });
    reader.readAsText(fileObject);
  }
}
