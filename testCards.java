package com.untitled;

import java.util.*;

/**
 * Created by lenovo on 2017/7/29.
 */
public class testCards {
   cards [] allCard = {new cards("黑桃A"),new cards("黑桃2"),new cards("黑桃3"),new cards("黑桃4"),new cards("黑桃5"),
           new cards("黑桃6"),new cards("黑桃6"),new cards("黑桃7"),new cards("黑桃8"),new cards("黑桃9"),new cards("黑桃10"),
           new cards("黑桃J"),new cards("黑桃Q"),new cards("黑桃K"),new cards("红心A"),new cards("红心2"),new cards("红心3"),
           new cards("红心4"),new cards("红心5"), new cards("红心6"),new cards("红心6"),new cards("红心7"),new cards("红心8"),
           new cards("红心9"),new cards("红心10"), new cards("红心J"),new cards("红心Q"),new cards("红心K"),new cards("梅花A"),
           new cards("梅花2"),new cards("梅花3"),new cards("梅花4"),new cards("梅花5"), new cards("梅花6"),new cards("梅花6"),
           new cards("梅花7"),new cards("梅花8"),new cards("梅花9"),new cards("梅花10"),new cards("梅花J"),new cards("梅花Q"),
           new cards("梅花K"),new cards("方块A"),new cards("方块2"),new cards("方块3"),new cards("方块4"),new cards("方块5"),
           new cards("方块6"),new cards("方块6"),new cards("方块7"),new cards("方块8"),new cards("方块9"),new cards("方块10"),
           new cards("方块J"),new cards("方块Q"),new cards("方块K")};
   List<cards> newlist = new ArrayList<cards>();
   List<cards> xipaiList = new ArrayList<cards>();
   player p1 = new player();
   player p2 = new player();
   Scanner console = new Scanner(System.in);
   public void addcards(){
       newlist.addAll(Arrays.asList(allCard));
       System.out.println("牌局开始！");
   }
   public void randomCards(){
       while(newlist.size()>0){
           Random random = new Random();
           int c= random.nextInt(newlist.size());
           xipaiList.add(newlist.get(c));
           newlist.remove(c);
       }
       System.out.println("------------------洗牌-------------------");
       for (cards c0:xipaiList) {
           System.out.print(c0.getClass().getName()+",");
       }
       System.out.println();
   }
   public void addPlayer(){
       while(true){
           try{
               System.out.println("----------------请输入------------------");
               System.out.println("请输入第一位玩家的ID：");
               p1.id = console.nextInt();
               System.out.println("请输入第一位玩家的姓名：");
               p1.name = console.next();
               System.out.println("请输入第二位玩家的ID：");
               p2.id = console.nextInt();
               System.out.println("请输入第二位玩家的姓名：");
               p2.name = console.next();
               if(p1.id==p2.id||p1.name==p2.name){
                   System.out.println("玩家ID或者姓名不能相同！");
                   continue;
               }
               break;
           }catch(InputMismatchException e){
               System.out.println("请输入整数！");
               continue;
           }catch(Exception e){
               e.printStackTrace();
           }finally {
               console = new Scanner(System.in);
           }
       }
       System.out.println("欢迎玩家"+p1.id+":"+p1.name+"加入游戏！");
       System.out.println("欢迎玩家"+p2.id+":"+p2.name+"加入游戏！");
   }
   public void getCards(){
       Iterator<cards> it = xipaiList.iterator();
       for(int i=0;i<2;i++){
           p1.myCards.add(it.next());
           p2.myCards.add(it.next());
       }
       System.out.println("--------------发牌完成-----------------");
       System.out.print("玩家"+p1.id+":"+p1.name+"  手牌：");
       for(cards p0:p1.myCards){
           System.out.println(p0.name+",");
       }
       System.out.println();
       System.out.print("玩家"+p2.id+":"+p2.name+"  手牌：");
       for(cards p0:p2.myCards){
           System.out.println(p0.name+",");
       }
       System.out.println();
   }
   public void winner(){
       String p1max;
       String p2max;
       System.out.println("--------------------结果-------------------");
       if(p1.myCards.get(0).value.compareTo(p1.myCards.get(1).value)>0)
           p1max = p1.myCards.get(0).value;
       else
           p1max = p1.myCards.get(1).value;
       if(p2.myCards.get(0).value.compareTo(p2.myCards.get(1).value)>0)
           p2max = p2.myCards.get(0).value;
       else
           p2max = p1.myCards.get(1).value;
       if(p1max.compareTo(p2max)>0)
           System.out.println("玩家"+p1.id+":"+p1.name+"获胜！");
       else
           System.out.println("玩家"+p2.id+":"+p2.name+"获胜！");
   }

    public static void main(String[] args) {
       testCards te = new testCards();
       te.addcards();
       te.randomCards();
       te.addPlayer();
       te.getCards();
       te.winner();
    }
}
