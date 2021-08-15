import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyLinkedNote {
	public static void main(String args[]){
		JFrame w = new JFrame() ;
		w.setSize(300, 400);

		MyPanel mp = new MyPanel();
		w.add(mp);

		w.addKeyListener(mp);
		mp.addKeyListener(mp);

		w.setVisible(true);
	}
}

class MyPanel extends JPanel implements KeyListener {
	Node firstNode = new Node() ;//定义第一个节点
	Node nowNode = firstNode ;//当前节点
	int cursor = 0 ;
	public void paint(Graphics g) {
		super.paint(g);
		//遍历每个节点
		//声明的临时变量是Node类型的，这样才能够指向每个节点
		Node tmpNode = firstNode ;
		int x = 0 ;//需要调整x坐标
		while(tmpNode.next!=null){//最后一个节点的next是null
			g.drawString(""+tmpNode.next.value, 10+x*8, 10) ;
			x ++ ;
			//让tmpNode在链表中向下移动
			tmpNode = tmpNode.next ;
		}
		
		//显示光标
		g.drawLine(10+cursor*8, 0, 10+cursor*8, 10) ;
	}

	@Override
	public void keyPressed(KeyEvent e) {
	   if(e.getKeyCode()>=KeyEvent.VK_A&&e.getKeyCode()<=KeyEvent.VK_Z) {
			if(nowNode.next==null){//末尾的追加模式
				Node newNode = new Node() ;
				newNode.value = e.getKeyChar() ;
				nowNode.next = newNode ;
				nowNode = newNode ;
				cursor ++ ;
			}else {
				//1、创建新节点
				Node newNode = new Node() ;
				//2、赋值
				newNode.value = e.getKeyChar() ;
				//3、让新节点的next指向下一个节点
				newNode.next = nowNode.next ;
				//4、让当前节点的next指向新节点
				nowNode.next = newNode ;
				//5、维护nowNode和光标
				nowNode = newNode ;
				cursor ++ ;
			}		
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(cursor>0){
				cursor -- ;
				//从第一个节点开始，找到当前节点的前一个节点
				Node tmpNode = firstNode ;
				while(tmpNode.next!=nowNode){//思考一下循环条件
					tmpNode = tmpNode.next ;
				}
				nowNode = tmpNode ;//修改nowNode的值
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(nowNode.next!=null){//思考范围条件
				cursor ++ ;
				nowNode = nowNode.next ;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_DELETE){
			if(nowNode.next!=null){
				nowNode.next = nowNode.next.next ;
			}		
		}
		repaint();
	}
	
	public void keyReleased(KeyEvent arg0) {
	}
	
	public void keyTyped(KeyEvent arg0) {
	}
}

class Node {
	public char value = ' ';
	public Node next = null ;
}