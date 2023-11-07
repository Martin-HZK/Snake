package com.t.snakeGame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
import java.util.Random;
//
//public class GamePanel extends JPanel implements ActionListener{
//
//	static final int SCREEN_WIDTH = 1300;
//	static final int SCREEN_HEIGHT = 750;
//	static final int UNIT_SIZE = 50;
//	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
//	static final int DELAY = 175;
//	final int x[] = new int[GAME_UNITS];
//	final int y[] = new int[GAME_UNITS];
//	int bodyParts = 6;
//	int applesEaten;
//	int appleX;
//	int appleY;
//	char direction = 'R';
//	boolean running = false;
//	Timer timer;
//	Random random;
//
//	GamePanel(){
//		random = new Random();
//		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
//		this.setBackground(Color.black);
//		this.setFocusable(true);
//		this.addKeyListener(new MyKeyAdapter());
//		startGame();
//	}
//	public void startGame() {
//		newApple();
//		running = true;
//		timer = new Timer(DELAY,this);
//		timer.start();
//	}
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		draw(g);
//	}
//	public void draw(Graphics g) {
//
//		if(running) {
//			/*
//			for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
//				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
//				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
//			}
//			*/
//			g.setColor(Color.red);
//			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
//
//			for(int i = 0; i< bodyParts;i++) {
//				if(i == 0) {
//					g.setColor(Color.green);
//					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
//				}
//				else {
//					g.setColor(new Color(45,180,0));
//					//g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
//					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
//				}
//			}
//			g.setColor(Color.red);
//			g.setFont( new Font("Ink Free",Font.BOLD, 40));
//			FontMetrics metrics = getFontMetrics(g.getFont());
//			g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
//		}
//		else {
//			gameOver(g);
//		}
//
//	}
//	public void newApple(){
//		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
//		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
//	}
//	public void move(){
//		for(int i = bodyParts;i>0;i--) {
//			x[i] = x[i-1];
//			y[i] = y[i-1];
//		}
//
//		switch(direction) {
//		case 'U':
//			y[0] = y[0] - UNIT_SIZE;
//			break;
//		case 'D':
//			y[0] = y[0] + UNIT_SIZE;
//			break;
//		case 'L':
//			x[0] = x[0] - UNIT_SIZE;
//			break;
//		case 'R':
//			x[0] = x[0] + UNIT_SIZE;
//			break;
//		}
//
//	}
//	public void checkApple() {
//		if((x[0] == appleX) && (y[0] == appleY)) {
//			bodyParts++;
//			applesEaten++;
//			newApple();
//		}
//	}
//	public void checkCollisions() {
//		//checks if head collides with body
//		for(int i = bodyParts;i>0;i--) {
//			if((x[0] == x[i])&& (y[0] == y[i])) {
//				running = false;
//			}
//		}
//		//check if head touches left border
//		if(x[0] < 0) {
//			running = false;
//		}
//		//check if head touches right border
//		if(x[0] > SCREEN_WIDTH) {
//			running = false;
//		}
//		//check if head touches top border
//		if(y[0] < 0) {
//			running = false;
//		}
//		//check if head touches bottom border
//		if(y[0] > SCREEN_HEIGHT) {
//			running = false;
//		}
//
//		if(!running) {
//			timer.stop();
//		}
//	}
//	public void gameOver(Graphics g) {
//		//Score
//		g.setColor(Color.red);
//		g.setFont( new Font("Ink Free",Font.BOLD, 40));
//		FontMetrics metrics1 = getFontMetrics(g.getFont());
//		g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
//		//Game Over text
//		g.setColor(Color.red);
//		g.setFont( new Font("Ink Free",Font.BOLD, 75));
//		FontMetrics metrics2 = getFontMetrics(g.getFont());
//		g.drawString("Game Over lol get rekt", (SCREEN_WIDTH - metrics2.stringWidth("Game Over lol get rekt"))/2, SCREEN_HEIGHT/2);
//	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//		if(running) {
//			move();
//			checkApple();
//			checkCollisions();
//		}
//		repaint();
//	}
//
//	public class MyKeyAdapter extends KeyAdapter{
//		@Override
//		public void keyPressed(KeyEvent e) {
//			switch(e.getKeyCode()) {
//			case KeyEvent.VK_LEFT:
//				if(direction != 'R') {
//					direction = 'L';
//				}
//				break;
//			case KeyEvent.VK_RIGHT:
//				if(direction != 'L') {
//					direction = 'R';
//				}
//				break;
//			case KeyEvent.VK_UP:
//				if(direction != 'D') {
//					direction = 'U';
//				}
//				break;
//			case KeyEvent.VK_DOWN:
//				if(direction != 'U') {
//					direction = 'D';
//				}
//				break;
//			}
//		}
//	}
//}

// TODO: implement in Javafx
public class GamePanel extends Pane {

	static final int SCREEN_WIDTH = 1300;
	static final int SCREEN_HEIGHT = 750;
	static final int UNIT_SIZE = 50;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
	static final int DELAY = 175;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int bodyParts = 6;
	int applesEaten;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean running = false;
	AnimationTimer timer;
	Random random = new Random();

	// below are the own-added vars
//	Stage playWindow;
	Scene playingScene;

//	GamePanel(){
//		random = new Random();
////		this.setPrefSize(SCREEN_WIDTH,SCREEN_HEIGHT);
////		this.setStyle("-fx-background-color: black;");
//		this.setFocusTraversable(true);
//
////		this.start(null);
//	}

	/**
	 * This is the start stage
	 * @param primaryStage
	 */
	public void start(Stage primaryStage) {
		// for the primitive version, we only have 2 stages,one gaming stage, one game over stage
//		playWindow = primaryStage;
		Pane root = new StackPane();
//		this.setStyle("-fx-background-color: black;");

		Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
		root.getChildren().add(canvas);
		GraphicsContext gc = canvas.getGraphicsContext2D();


		playingScene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
		playingScene.setFill(Color.BLACK);
		primaryStage.setScene(playingScene);
		primaryStage.setTitle("Snake");
		primaryStage.show();

		newApple();
		playingScene.setOnKeyPressed(e -> {
			switch ((e.getCode())) {
				case LEFT:
					if(direction != 'R') {
						direction = 'L';
					}
					break;
				case RIGHT:
					if(direction != 'L') {
						direction = 'R';
					}
					break;
				case UP:
					if(direction != 'D') {
						direction = 'U';
					}
					break;
				case DOWN:
					if(direction != 'U') {
						direction = 'D';
					}
					break;
			}
		});

		running = true;
		timer = new AnimationTimer() {
			@Override
			public void handle(long l) {
				if (running){
					move();
					checkApple();
					checkCollisions();
				}
				draw(gc);
			}
		};
		timer.start();

	}

	public void newApple(){
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
	}
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		draw(g);
//	}

	public void draw(GraphicsContext g) {
		if(running) {
			/*
			for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			}
			*/
			g.setFill(Color.RED);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

			for(int i = 0; i< bodyParts;i++) {
				if(i == 0) {
					g.setFill(Color.GREEN);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
				else {
					g.setFill(new Color(45.0/255,180.0/255,0,  1.0));
					//g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
			g.setFill(Color.RED);
			g.setFont(Font.font("Ink Free", FontWeight.BOLD, 40));
//			FontMetrics metrics = g.getFontMetrics();
			g.fillText("Score: "+applesEaten, (SCREEN_WIDTH - ("Score: "+applesEaten).length()*10)/2, g.getFont().getSize());
		}
		else {
			gameOver(g);
		}
	}
	public void move(){
		for(int i = bodyParts;i>0;i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}

		switch(direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}

	}
	public void checkApple() {
		if((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			applesEaten++;
			newApple();
		}
	}
	public void checkCollisions() {
		//checks if head collides with body
		for(int i = bodyParts;i>0;i--) {
			if((x[0] == x[i])&& (y[0] == y[i])) {
				running = false;
			}
		}
		//check if head touches left border
		if(x[0] < 0) {
			running = false;
		}
		//check if head touches right border
		if(x[0] > SCREEN_WIDTH) {
			running = false;
		}
		//check if head touches top border
		if(y[0] < 0) {
			running = false;
		}
		//check if head touches bottom border
		if(y[0] > SCREEN_HEIGHT) {
			running = false;
		}

		if(!running) {
			timer.stop();
		}
	}
	public void gameOver(GraphicsContext g) {
		//Score
		g.setFill(Color.RED);
		g.setFont(Font.font("Ink Free",FontWeight.BOLD, 40));// Font.font("Ink Free", FontWeight.BOLD, 40)
//		FontMetrics metrics1 = g.getFontMetrics();
		g.fillText("Score: "+applesEaten, (SCREEN_WIDTH - ("Score: "+applesEaten).length() * 10)/2, g.getFont().getSize());
		//Game Over text
		g.setFill(Color.RED);
		g.setFont(Font.font("Ink Free",FontWeight.BOLD, 75));
//		FontMetrics metrics2 = g.getFontMetrics();
		g.fillText("Game Over lol get rekt", (SCREEN_WIDTH - ("Game Over lol get rekt").length() * 10)/2, SCREEN_HEIGHT/2);
	}
	// in javafx we use animation timer to do the repaint
//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//		if(running) {
//			move();
//			checkApple();
//			checkCollisions();
//		}
//		repaint();
//	}
}