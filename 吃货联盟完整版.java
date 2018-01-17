import java.util.Scanner;

/**
 * 
 * 吃货联盟订餐系统
 * */

public class Demo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//框架
		//
		Scanner input=new Scanner(System.in);
		int num=-1;
		boolean isFign=false; //false不退出  true退出
		System.out.println("欢迎使用吃货联盟订餐系统！！！");
		//订单信息
		String[] names=new String[4];  //订单中的姓名
		String[] dishMegs=new String[4]; //订单中的菜品信息
		int[] times=new int[4];          //订单中的送餐时间
		String[] addresses=new String[4];//订单中的送餐地址
		int[] states=new int[4];         //订单中的状态;(预定/签收);
		double[] sumPrices=new double[4];//订单中的菜品总价格；
		//初始化菜品信息
		String[] dishNames={"鱼香肉丝","宫保鸡丁","黄焖鸡"};
		double[] dishPrices={15.0,13.0,20.0};
		int[] dishPraises=new int[3];		
		//初始化订单信息  --张三
		names[0]="张三";
		dishMegs[0]="鱼香肉丝1份";
		times[0]=12;
		addresses[0]="时瑞大厦6楼";
		states[0]=1;  //1 签收
		sumPrices[0]=20.0;
		//--初始化  李四
		names[1]="李四";
		dishMegs[1]="黄焖鸡3份";
		times[1]=13;
		addresses[1]="文一西路财经学院";
		//states[1]=0;  //1 签收
		sumPrices[1]=60.0;
		
		do{
			//执行主菜单
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("请输入您要选择的功能：");
			int numChoice=input.nextInt();
			switch(numChoice){
			case 1:
				System.out.println("**********欢迎使用订餐功能**********");
				boolean isAdd=false;  //false不能再添加新的订单 
				for(int i=0;i<names.length;i++){
					if(names[i]==null){
						isAdd=true;  //可以添加新的订单
						System.out.println("请输入您的姓名：");
						String name=input.next();
						System.out.println("序号\t菜品名\t菜品价格\t点赞数");
						for(int j=0;j<dishNames.length;j++){
							String price=dishPrices[j]+"元";
							String praise=(dishPraises[j]>0)?dishPraises[j]+"个赞":"0个赞";
						    System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);  
						}
						System.out.println("请选择您要订的菜品序号：");
						int dishChoice=input.nextInt();
						System.out.println("请选择您要定的份数：");
						int number=input.nextInt();
						double sumPrice=dishPrices[dishChoice-1]*number;  //订单总价格
						//配送费  >=50? 0  5;
						int delCharge=sumPrice>=50?0:5;
						System.out.println("请输入您的送餐地址：");
						String address=input.next();
						System.out.println("请输入送餐时间：");
						int time=input.nextInt();
						while(time<10 || time>20){
							System.out.println("时间错误，请从新输入送餐时间：");
							time=input.nextInt();
						}
						System.out.println("您订的菜品信息如下：");
						System.out.println("送餐时间："+time+"点");
						System.out.println("送餐地址："+address);
						System.out.println("订单的总价格："+sumPrice+delCharge+"元");
						names[i]=name;
						dishMegs[i]=dishNames[dishChoice-1]+number+"份";
						times[i]=time;
						addresses[i]=address;
						//states[i]=0;
						sumPrices[i]=sumPrice+delCharge;
						break;
					}
				}
				if(!isAdd){
					System.out.println("对不起，订单已满，不能添加新的订单");
				}
				break;
			case 2:
				System.out.println("**********欢迎使用查看餐袋功能**********");
				System.out.println();
				System.out.println("序号\t姓名\t菜品信息\t\t送餐时间\t送餐地址\t\t订单状态\t订单总价格");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String time=times[i]+"点";
						String state=(states[i]==0)?"预定":"已签收";
						String sumPrice=sumPrices[i]+"元";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time
								+"\t"+addresses[i]+"\t"+state+"\t"+sumPrice);
					}
				}
				break;
			case 3:
				System.out.println("**********欢迎使用签收订单功能**********");
			    boolean isSignFind=false;  //false没有找到
			    System.out.println("请输入要签收的订单号：");
			    int numSign=input.nextInt();
			    for(int i=0;i<names.length;i++){
			    	if(names[i]!=null && states[i]==0 && numSign==i+1){
			    		isSignFind=true;
			    		states[i]=1;
			    		System.out.println("签收成功！！");
			    		break;
			    	}else if(names[i]!=null && states[i]==1 && numSign==i+1){
			    		isSignFind=true;
			    		System.out.println("已经签收，请不要重复签收");
			    		break;
			    	}
			    }
			    if(!isSignFind){
			    	System.out.println("没有找到该订单！");
			    }
				break;
			case 4:
				System.out.println("**********欢迎使用删除订单功能**********");
				boolean isDelFind=false;  //默认false 没有找到
				System.out.println("请输入要删除的订单号：");
				int delNum=input.nextInt();
				for(int i=0;i<names.length;i++){
					if(names[i]!=null && states[i]==1 && delNum==i+1){
						isDelFind=true;
						//可以删除
						//将要删除的元素后面的元素依次往前移
						for(int j=delNum-1;j<names.length-1;j++){
							names[j]=names[j+1];
							dishMegs[j]=dishMegs[j+1];
							times[j]=times[j+1];
							addresses[j]=addresses[j+1];
							states[j]=states[j+1];
							sumPrices[j]=sumPrices[j+1];		
						}
						//清空最后一个元素
						int index=names.length-1;
						names[index]=null;
						dishMegs[index]=null;
						times[index]=0;
						addresses[index]=null;
						states[index]=0;
						sumPrices[index]=0.0;
						System.out.println("删除成功！");
						break;
					}else if(names[i]!=null && states[i]==0 && delNum==i+1){
						isDelFind=true;
						//不可以删除预定状态的订单
						System.out.println("不可以删除预定状态的订单");
						break;
					}
				}
				if(!isDelFind){
					System.out.println("没有找到要删除的订单");
				}
				
				break;
			case 5:
				System.out.println("**********欢迎使用我要点赞功能**********");
				System.out.println("序号\t菜品名\t菜品价格\t点赞数");
				for(int j=0;j<dishNames.length;j++){
					String price=dishPrices[j]+"元";
					String praise=(dishPraises[j]>0)?dishPraises[j]+"个赞":"0个赞";
				    System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);  
				}
				System.out.println("请输入要点赞的菜品序号：");
				int praiseNum=input.nextInt();
				dishPraises[praiseNum-1]++;
				System.out.println("点赞成功！");
				break;
			case 6:
				System.out.println("**********退出系统！！！*********");
				isFign=true; //退出
				break;
			default:
				isFign=true; //退出
				break;
			}
			if(!isFign){
				System.out.println("请输入0返回主菜单：");
				num=input.nextInt();
			}else{
				break;
			}		
		}while(num==0);
       System.out.println("谢谢使用吃货联盟订餐系统 ！！");
	}

}
