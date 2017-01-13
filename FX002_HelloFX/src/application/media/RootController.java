package application.media;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class RootController implements Initializable {
	
  @FXML private MediaView mediaView;
	@FXML private ImageView imageView;
	
	@FXML private ProgressBar progressBar;
	@FXML private ProgressIndicator progressIndicator;
	@FXML private Slider sliderVolum;
	@FXML private Label labelTime;
	
	@FXML private Button btnPlay;
	@FXML private Button btnPause;
	@FXML private Button btnStop;
	
	private boolean endOfMedia;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Media media = new Media("file:/c:/Android/git_fx/FX002_HelloFX/media/video.mp4");

		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
	
		mediaPlayer.setOnReady(new Runnable() {
			@Override
			public void run() {
			  
			  mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>(){

          @Override
          public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
            // TODO Auto-generated method stub
            
            double progress = mediaPlayer.getCurrentTime().toSeconds() /
                mediaPlayer.getTotalDuration().toSeconds();
            
            progressBar.setProgress(progress);
            progressIndicator.setProgress(progress);
            labelTime.setText((int)mediaPlayer.getCurrentTime().toSeconds() + " / " +
                            (int)mediaPlayer.getTotalDuration().toSeconds()+" sec");        
          }
			    
        });
			  
			  
				btnPlay.setDisable(false); btnPause.setDisable(true); btnStop.setDisable(true);
				if(mediaPlayer.isAutoPlay()) {mediaView.setVisible(false);}
			}
		});
		mediaPlayer.setOnPlaying(()->{
			btnPlay.setDisable(true); btnPause.setDisable(false); btnStop.setDisable(false);
		});
		mediaPlayer.setOnPaused(()->{
			btnPlay.setDisable(false); btnPause.setDisable(true); btnStop.setDisable(false);
		});
		mediaPlayer.setOnEndOfMedia(()->{
			endOfMedia = true;
			btnPlay.setDisable(false); btnPause.setDisable(true); btnStop.setDisable(true);
		});
		mediaPlayer.setOnStopped(()->{
			mediaPlayer.seek(mediaPlayer.getStartTime());
			btnPlay.setDisable(false); btnPause.setDisable(true); btnStop.setDisable(true);
		});
		

		btnPlay.setOnAction(event->{
			if(endOfMedia) { 
				mediaPlayer.stop(); 
				mediaPlayer.seek(mediaPlayer.getStartTime());
			}
			mediaPlayer.play();
			endOfMedia = false;
		});
		
		btnPause.setOnAction(event->mediaPlayer.pause());
		btnStop.setOnAction(event->mediaPlayer.stop());
	}
}
