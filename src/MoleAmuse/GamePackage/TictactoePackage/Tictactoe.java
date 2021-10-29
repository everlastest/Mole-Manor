package MoleAmuse.GamePackage.TictactoePackage;

import MoleAmuse.GamePackage.Game;
import MoleAmuse.GamePackage.TictactoePackage.Object.AbstractChess;
import MoleAmuse.GamePackage.TictactoePackage.Object.ChessBoard;

import java.util.Random;
import java.util.Scanner;

public class Tictactoe implements Game {

    @Override
    public void Play() {

        //初始化棋子
        System.out.println("启动井字棋游戏，开始初始化！！！");

        //创造井字棋工厂
        TictactoeFactory tictactoeFactory = TictactoeFactory.getInstance();

        //生成棋子对象
        AbstractChess abstractChess = null;
        abstractChess = tictactoeFactory.getChessObject('B');
        abstractChess = tictactoeFactory.getChessObject('W');

        //初始化棋盘
        ChessBoard chessBoard = null;
        chessBoard = tictactoeFactory.getChessBoard();

        //初始化摩尔选择的棋子
        System.out.println("请选择你的棋子，‘B’代表黑棋，‘W’代表白棋");
        Character chesstype = null;
        Scanner scan = new Scanner(System.in);
        while (chesstype == null) {
            switch (scan.next()) {
                case "B":
                    chesstype = 'B';
                    System.out.println("你已选择黑棋！");
                    break;
                case "W":
                    chesstype = 'W';
                    System.out.println("你已选择白棋！");
                    break;
                default:
                    System.out.println("输入错误，请重新选择：");
                    break;
            }
        }

        //记录结果
        int result = 0;
        //记录坐标
        int point = 0;

        System.out.println("初始化成功，游戏开始！！！\n");

        //显示棋盘
        chessBoard.show();

        Random random = new Random();

        /**
         * 游戏由“*”方先落子，因此分为两种情况
         */
        while(result == 0)
        {
            //情况一：摩尔选择“⚪”
            if(chesstype == 'W') {
                try {
                    System.out.println("电脑正在思考中......");
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                abstractChess = tictactoeFactory.getChessObject('B');

                int r = 0;

                //电脑放置棋子
                do {
                    r = random.nextInt(8) + 1;
                }
                while(tictactoeFactory.getchess(r, abstractChess, chessBoard) == false);

                abstractChess.Point(r);

                chessBoard.show();

                //判断结果
                result = tictactoeFactory.getresult(r, abstractChess, chessBoard);
                if(result == 1)
                    break;



                //转为摩尔方
                abstractChess = tictactoeFactory.getChessObject('W');

                //选择要走的坐标
                System.out.println("请输入要走的坐标:");
                do {
                    if (scan.hasNext()) {
                        point = scan.nextInt();
                    }
                }
                while (tictactoeFactory.getchess(point, abstractChess, chessBoard) == false);

                abstractChess.Point(point);

                chessBoard.show();

                result = tictactoeFactory.getresult(point, abstractChess, chessBoard);
            }

            //情况二：摩尔选择“*”
            else {

                abstractChess = tictactoeFactory.getChessObject('B');

                //选择要走的坐标
                do {
                    System.out.println("请输入要走的坐标:");
                    if (scan.hasNext()) {
                        point = scan.nextInt();
                    }
                }
                while (tictactoeFactory.getchess(point, abstractChess, chessBoard) == false);
                abstractChess.Point(point);

                //输出棋盘
                chessBoard.show();

                //判断结果
                result = tictactoeFactory.getresult(point, abstractChess, chessBoard);
                if(result == 1)
                    break;

                try {
                    System.out.println("电脑正在思考中......");
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //电脑方
                abstractChess=tictactoeFactory.getChessObject('W');

                int r = 0;
                do {
                    r = random.nextInt(8) + 1;
                }
                while(tictactoeFactory.getchess(r, abstractChess, chessBoard) == false);

                abstractChess.Point(r);

                chessBoard.show();

                result = tictactoeFactory.getresult(r, abstractChess, chessBoard);
                abstractChess=tictactoeFactory.getChessObject('B');
            }
        }

        System.out.println("正在退出井字棋游戏......\n成功退出，已返回游乐园！！！\n");


    }

}