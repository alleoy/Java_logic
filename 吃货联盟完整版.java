import java.util.Scanner;

/**
 * 
 * �Ի����˶���ϵͳ
 * */

public class Demo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���
		//
		Scanner input=new Scanner(System.in);
		int num=-1;
		boolean isFign=false; //false���˳�  true�˳�
		System.out.println("��ӭʹ�óԻ����˶���ϵͳ������");
		//������Ϣ
		String[] names=new String[4];  //�����е�����
		String[] dishMegs=new String[4]; //�����еĲ�Ʒ��Ϣ
		int[] times=new int[4];          //�����е��Ͳ�ʱ��
		String[] addresses=new String[4];//�����е��Ͳ͵�ַ
		int[] states=new int[4];         //�����е�״̬;(Ԥ��/ǩ��);
		double[] sumPrices=new double[4];//�����еĲ�Ʒ�ܼ۸�
		//��ʼ����Ʒ��Ϣ
		String[] dishNames={"������˿","��������","���˼�"};
		double[] dishPrices={15.0,13.0,20.0};
		int[] dishPraises=new int[3];		
		//��ʼ��������Ϣ  --����
		names[0]="����";
		dishMegs[0]="������˿1��";
		times[0]=12;
		addresses[0]="ʱ�����6¥";
		states[0]=1;  //1 ǩ��
		sumPrices[0]=20.0;
		//--��ʼ��  ����
		names[1]="����";
		dishMegs[1]="���˼�3��";
		times[1]=13;
		addresses[1]="��һ��·�ƾ�ѧԺ";
		//states[1]=0;  //1 ǩ��
		sumPrices[1]=60.0;
		
		do{
			//ִ�����˵�
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("��������Ҫѡ��Ĺ��ܣ�");
			int numChoice=input.nextInt();
			switch(numChoice){
			case 1:
				System.out.println("**********��ӭʹ�ö��͹���**********");
				boolean isAdd=false;  //false����������µĶ��� 
				for(int i=0;i<names.length;i++){
					if(names[i]==null){
						isAdd=true;  //��������µĶ���
						System.out.println("����������������");
						String name=input.next();
						System.out.println("���\t��Ʒ��\t��Ʒ�۸�\t������");
						for(int j=0;j<dishNames.length;j++){
							String price=dishPrices[j]+"Ԫ";
							String praise=(dishPraises[j]>0)?dishPraises[j]+"����":"0����";
						    System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);  
						}
						System.out.println("��ѡ����Ҫ���Ĳ�Ʒ��ţ�");
						int dishChoice=input.nextInt();
						System.out.println("��ѡ����Ҫ���ķ�����");
						int number=input.nextInt();
						double sumPrice=dishPrices[dishChoice-1]*number;  //�����ܼ۸�
						//���ͷ�  >=50? 0  5;
						int delCharge=sumPrice>=50?0:5;
						System.out.println("�����������Ͳ͵�ַ��");
						String address=input.next();
						System.out.println("�������Ͳ�ʱ�䣺");
						int time=input.nextInt();
						while(time<10 || time>20){
							System.out.println("ʱ���������������Ͳ�ʱ�䣺");
							time=input.nextInt();
						}
						System.out.println("�����Ĳ�Ʒ��Ϣ���£�");
						System.out.println("�Ͳ�ʱ�䣺"+time+"��");
						System.out.println("�Ͳ͵�ַ��"+address);
						System.out.println("�������ܼ۸�"+sumPrice+delCharge+"Ԫ");
						names[i]=name;
						dishMegs[i]=dishNames[dishChoice-1]+number+"��";
						times[i]=time;
						addresses[i]=address;
						//states[i]=0;
						sumPrices[i]=sumPrice+delCharge;
						break;
					}
				}
				if(!isAdd){
					System.out.println("�Բ��𣬶�����������������µĶ���");
				}
				break;
			case 2:
				System.out.println("**********��ӭʹ�ò鿴�ʹ�����**********");
				System.out.println();
				System.out.println("���\t����\t��Ʒ��Ϣ\t\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t����״̬\t�����ܼ۸�");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String time=times[i]+"��";
						String state=(states[i]==0)?"Ԥ��":"��ǩ��";
						String sumPrice=sumPrices[i]+"Ԫ";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time
								+"\t"+addresses[i]+"\t"+state+"\t"+sumPrice);
					}
				}
				break;
			case 3:
				System.out.println("**********��ӭʹ��ǩ�ն�������**********");
			    boolean isSignFind=false;  //falseû���ҵ�
			    System.out.println("������Ҫǩ�յĶ����ţ�");
			    int numSign=input.nextInt();
			    for(int i=0;i<names.length;i++){
			    	if(names[i]!=null && states[i]==0 && numSign==i+1){
			    		isSignFind=true;
			    		states[i]=1;
			    		System.out.println("ǩ�ճɹ�����");
			    		break;
			    	}else if(names[i]!=null && states[i]==1 && numSign==i+1){
			    		isSignFind=true;
			    		System.out.println("�Ѿ�ǩ�գ��벻Ҫ�ظ�ǩ��");
			    		break;
			    	}
			    }
			    if(!isSignFind){
			    	System.out.println("û���ҵ��ö�����");
			    }
				break;
			case 4:
				System.out.println("**********��ӭʹ��ɾ����������**********");
				boolean isDelFind=false;  //Ĭ��false û���ҵ�
				System.out.println("������Ҫɾ���Ķ����ţ�");
				int delNum=input.nextInt();
				for(int i=0;i<names.length;i++){
					if(names[i]!=null && states[i]==1 && delNum==i+1){
						isDelFind=true;
						//����ɾ��
						//��Ҫɾ����Ԫ�غ����Ԫ��������ǰ��
						for(int j=delNum-1;j<names.length-1;j++){
							names[j]=names[j+1];
							dishMegs[j]=dishMegs[j+1];
							times[j]=times[j+1];
							addresses[j]=addresses[j+1];
							states[j]=states[j+1];
							sumPrices[j]=sumPrices[j+1];		
						}
						//������һ��Ԫ��
						int index=names.length-1;
						names[index]=null;
						dishMegs[index]=null;
						times[index]=0;
						addresses[index]=null;
						states[index]=0;
						sumPrices[index]=0.0;
						System.out.println("ɾ���ɹ���");
						break;
					}else if(names[i]!=null && states[i]==0 && delNum==i+1){
						isDelFind=true;
						//������ɾ��Ԥ��״̬�Ķ���
						System.out.println("������ɾ��Ԥ��״̬�Ķ���");
						break;
					}
				}
				if(!isDelFind){
					System.out.println("û���ҵ�Ҫɾ���Ķ���");
				}
				
				break;
			case 5:
				System.out.println("**********��ӭʹ����Ҫ���޹���**********");
				System.out.println("���\t��Ʒ��\t��Ʒ�۸�\t������");
				for(int j=0;j<dishNames.length;j++){
					String price=dishPrices[j]+"Ԫ";
					String praise=(dishPraises[j]>0)?dishPraises[j]+"����":"0����";
				    System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);  
				}
				System.out.println("������Ҫ���޵Ĳ�Ʒ��ţ�");
				int praiseNum=input.nextInt();
				dishPraises[praiseNum-1]++;
				System.out.println("���޳ɹ���");
				break;
			case 6:
				System.out.println("**********�˳�ϵͳ������*********");
				isFign=true; //�˳�
				break;
			default:
				isFign=true; //�˳�
				break;
			}
			if(!isFign){
				System.out.println("������0�������˵���");
				num=input.nextInt();
			}else{
				break;
			}		
		}while(num==0);
       System.out.println("ллʹ�óԻ����˶���ϵͳ ����");
	}

}
