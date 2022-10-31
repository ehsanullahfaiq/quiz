


	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	public class Quize {

	public JFrame frame;
	public JPanel p1,p2,p3;
	public JLabel [] arrayLabels;
	public JRadioButton [] arrayRButtons;
	public ButtonGroup[] arrayGroups;
	public JPanel [] arrayPanels;
	public CardLayout cl;
	public JLabel lb1,lb2;
	public JButton btn1,btn2;
	public Timer tim;
	public int t,s;

	public Quize(){
	prepareGUI();
	}

	private void prepareGUI(){

	frame=new JFrame();
	frame.setSize(400, 400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setLayout(new BorderLayout());

	p1=new JPanel();
	p1.setLayout(new FlowLayout());

	lb1=new JLabel("Wellcome to quiz");

	cl=new CardLayout();

	p2=new JPanel();
	p2.setLayout(cl);

	arrayPanels = new JPanel[10];

	//A series of panels on which will rotate and show questions and answers
	for(int i=0;i<arrayPanels.length;i++){

	    arrayPanels[i] = new JPanel();
	    p2.add(arrayPanels[i], String.valueOf(i));
	    arrayPanels[i].setLayout(new GridLayout(0,1));

	}

	//Array RadioButtons with text

	arrayRButtons = new JRadioButton[40];

	for(int i=0;i<arrayRButtons.length;i++){
	    arrayRButtons[i] = new JRadioButton();

	    switch(i){
	        case 0:arrayRButtons[i].setText("Herat");
	            break;
	        case 1:arrayRButtons[i].setText("Kabul");
	            break;
	        case 2:arrayRButtons[i].setText("Bulkh");
	            break;
	        case 3:arrayRButtons[i].setText("Kundahar");
	            break;
	        case 4:arrayRButtons[i].setText("BAR");
	            break;
	        case 5:arrayRButtons[i].setText("RM");
	            break;
	        case 6:arrayRButtons[i].setText("MU");
	            break;
	        case 7:arrayRButtons[i].setText("MC");
	            break;
	        case 8:arrayRButtons[i].setText("India");
	            break;
	        case 9:arrayRButtons[i].setText("Rasia");
	            break;
	        case 10:arrayRButtons[i].setText("USA");
	            break;
	        case 11:arrayRButtons[i].setText("china");
	            break;
	        case 12:arrayRButtons[i].setText("Iran");
	            break;
	        case 13:arrayRButtons[i].setText("Vatican");
	            break;
	        case 14:arrayRButtons[i].setText("Afghanistan");
	            break;
	        case 15:arrayRButtons[i].setText("Tajistan");
	            break;
	        case 16:arrayRButtons[i].setText("Newyork");
	            break;
	        case 17:arrayRButtons[i].setText("Calfornia");
	            break;
	        case 18:arrayRButtons[i].setText("Florida");
	            break;
	        case 19:arrayRButtons[i].setText("Washinton DC");
	            break;
	        case 20:arrayRButtons[i].setText("Argintina");
	            break;
	        case 21:arrayRButtons[i].setText("Spain");
	            break;
	        case 22:arrayRButtons[i].setText("Germany");
	            break;
	        case 23:arrayRButtons[i].setText("Portugal");
	            break;
	        case 24:arrayRButtons[i].setText("Facebook");
	            break;
	        case 25:arrayRButtons[i].setText("Amazon");
	            break;
	        case 26:arrayRButtons[i].setText("MS");
	            break;
	        case 27:arrayRButtons[i].setText("Tesla");
	            break;
	        case 28:arrayRButtons[i].setText("Elon Musk");
	            break;
	        case 29:arrayRButtons[i].setText("Mark Zuckerberg");
	            break;
	        case 30:arrayRButtons[i].setText("Bill gits");
	            break;
	        case 31:arrayRButtons[i].setText("Trump");
	            break;
	        case 32:arrayRButtons[i].setText("Biden");
	            break;
	        case 33:arrayRButtons[i].setText("Baruk Obama");
	            break;
	        case 34:arrayRButtons[i].setText("Trump");
	            break;
	        case 35:arrayRButtons[i].setText("Hilary Clinton");
	            break;
	        case 36:arrayRButtons[i].setText("Joe Clark");
	            break;
	        case 37:arrayRButtons[i].setText("Arthur Meighen");
	            break;
	        case 38:arrayRButtons[i].setText("Justin Trudeau");
	            break;
	        case 39:arrayRButtons[i].setText("John Turner");
	            break;

	    }
	}

	//Array button's grups 
	arrayGroups=new ButtonGroup[10];

	int j=0;
	for(int i=0;i<arrayGroups.length;i++){

	arrayGroups[i] = new ButtonGroup();

	arrayGroups[i].add(arrayRButtons[j]);
	arrayGroups[i].add(arrayRButtons[j+1]);
	arrayGroups[i].add(arrayRButtons[j+2]);
	arrayGroups[i].add(arrayRButtons[j+3]);

	j+=4;
	}

	//Labels array with questions
	arrayLabels = new JLabel[10];

	for(int i=0;i<arrayLabels.length;i++){
	    arrayLabels[i] = new JLabel();
	    switch(i){
	        case 0:arrayLabels[i].setText("what is the capital of Afghanistan?");
	            break;
	        case 1:arrayLabels[i].setText("Wich Team the woner of champions legue in 2016?");
	            break;
	        case 2:arrayLabels[i].setText("Which country has the highst population?");
	            break;
	        case 3:arrayLabels[i].setText("Which country has the Lowest population?");
	            break;
	        case 4:arrayLabels[i].setText("which city is most expinsive in US?");
	            break;
	        case 5:arrayLabels[i].setText("Cristian Ronaldo borned in?");
	            break;
	        case 6:arrayLabels[i].setText("Elon Musk is the owner of? ");
	            break;
	        case 7:arrayLabels[i].setText("Facebook created by?");
	            break;
	        case 8:arrayLabels[i].setText("Who is the presedent of US?");
	            break;
	        case 9:arrayLabels[i].setText("who is the prime minister of Canada? ");
	            break;
	    }
	}

	p3=new JPanel();
	p3.setLayout(new FlowLayout());

	//Rotate panels with questions
	btn1=new JButton("Next question");
	btn1.setEnabled(false);
	btn1.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e){
	        cl.next(p2);
	        btn1.setEnabled(false);
	        btn2.setEnabled(true);
	        t=10;
	        lb2.setText(String.valueOf(t));
	        tim.start();
	        btn1.setText("Next question");
	    }
	});


	btn2=new JButton("Answer on question");
	btn2.addActionListener(new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e){
	        tim.stop();
	        btn1.setEnabled(true);

	        if(arrayRButtons[1].isSelected()
	            ||arrayRButtons[5].isSelected()
	            ||arrayRButtons[11].isSelected()
	            ||arrayRButtons[13].isSelected()
	            ||arrayRButtons[16].isSelected()
	            ||arrayRButtons[23].isSelected()
	            ||arrayRButtons[27].isSelected()
	            ||arrayRButtons[29].isSelected()
	            ||arrayRButtons[32].isSelected()){
	            s+=10;
	            JOptionPane.showMessageDialog(null, "Correct");
	        } else if(arrayRButtons[38].isSelected()){
	            s+=10;
	            JOptionPane.showMessageDialog(null, "Correct, you won: "+s+" points");
	            btn1.setText("Start again quiz");
	        }else if(arrayRButtons[33].isSelected()
	                ||arrayRButtons[34].isSelected()
	                ||arrayRButtons[35].isSelected()){
	            JOptionPane.showMessageDialog(null, "Wrong, you won: "+s+" points");
	            btn1.setText("Start again quiz");
	        }else{
	            JOptionPane.showMessageDialog(null, "Wrong");
	        }
	        for (int i = 0; i < 10; i++) {
	            arrayGroups[i].clearSelection();
	        }
	        btn2.setEnabled(false);
	    }

	});

	t=10;

	//Taimer
	lb2=new JLabel("10");
	tim=new Timer(1000,new ActionListener(){
	    
	    public void actionPerformed(ActionEvent e){
	        if(t>0){
	        t--;
	        lb2.setText(String.valueOf(t));
	        }else{
	            tim.stop();
	            JOptionPane.showMessageDialog(null, "Time's up");
	            btn2.setEnabled(false); 
	            btn1.setEnabled(true);
	            }
	        }
	    });
	}

	private void startGUI(){
	p1.add(lb1);

	p3.add(btn1);
	p3.add(btn2);
	p3.add(lb2);

	int q=0;
	for(int w=0;w<10;w++){

	arrayPanels[w].add(arrayLabels[w]);
	arrayPanels[w].add(arrayRButtons[q]);
	arrayPanels[w].add(arrayRButtons[q+1]);
	arrayPanels[w].add(arrayRButtons[q+2]);
	arrayPanels[w].add(arrayRButtons[q+3]);

	q+=4;
	}

	frame.add(p1,BorderLayout.NORTH);
	frame.add(p2,BorderLayout.CENTER);
	frame.add(p3,BorderLayout.SOUTH);

	cl.show(p2, "0");

	tim.start();
	frame.setVisible(true);

	}

	public static void main(String[] args) {
	Quize start=new Quize();
	start.startGUI();

	}
}

