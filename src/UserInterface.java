import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


public class UserInterface extends javax.swing.JFrame {

    
    ArrayList<String> firstS = new ArrayList<String>();
    ArrayList<String> secondS = new ArrayList<String>();
    ArrayList<String> thirdS = new ArrayList<String>();
    ArrayList<String> fourthS = new ArrayList<String>();
    ArrayList<String> fifthS = new ArrayList<String>();
    ArrayList<String> sixthS = new ArrayList<String>();
    ArrayList<String> seventhS = new ArrayList<String>();
    ArrayList<String> eigthS = new ArrayList<String>();
    ArrayList<String> ninthS = new ArrayList<String>();
    
    
    ArrayList<Float> firstF = new ArrayList<Float>();
    ArrayList<Float> secondF = new ArrayList<Float>();
    ArrayList<Float> thirdF = new ArrayList<Float>();
    ArrayList<Float> fourthF = new ArrayList<Float>();
    ArrayList<Float> fifthF = new ArrayList<Float>();
    ArrayList<Float> sixthF = new ArrayList<Float>();
    ArrayList<Float> seventhF = new ArrayList<Float>();
    ArrayList<Float> eigthF = new ArrayList<Float>();
    ArrayList<Float> ninthF = new ArrayList<Float>();
    
    ArrayList<Double> GainConsoldationRatio = new ArrayList<Double>();
     ArrayList<Double> SplitConsoldationRatio = new ArrayList<Double>();
    
    int glucoseLow = 0;
    int glucoseMed = 0;
    int glucosehigh=0;
    
    int bpLow = 0;
    int bpMed = 0;
    int bphigh=0;
    
    int pedigreeLow = 0;
    int pedigreeMed = 0;
    int pedigreehigh=0;
    
    int ageLow = 0;
    int ageMed = 0;
    int agehigh=0;
    
    //glucose
    int glLowYes = 0;    
    int glMedYes = 0;
    int glHighYes = 0; 
    
    int glLowNo = 0;    
    int glMedNo = 0;
    int glHighNo = 0; 
    
    //BP
    int bpLowYes = 0;    
    int bpMedYes = 0;
    int bpHighYes = 0;
    
    int bpLowNo = 0;    
    int bpMedNo = 0;
    int bpHighNo = 0;
    
    //pedigre
    int pdLowYes = 0;    
    int pdMedYes = 0;
    int pdHighYes = 0; 
    
     int pdLowNo = 0;    
    int pdMedNo = 0;
    int pdHighNo = 0; 
  
   //age
    int ageLowYes = 0;    
    int ageMedYes = 0;
    int ageHighYes = 0;
    
    int ageLowNo = 0;    
    int ageMedNo = 0;
    int ageHighNo = 0;
    
    double ElowForGlu = 0.0d;
    double EmedForGlu = 0.0d;
    double EHighForGlu = 0.0d;
    
    double ElowForBp = 0.0d;
    double EmedForBp = 0.0d;
    double EHighForBp = 0.0d;
    
    double ElowForPedigre = 0.0d;
    double EmedForPedigre = 0.0d;
    double EHighForPedigre = 0.0d;
   
    double ElowForAge = 0.0d;
    double EmedForAge = 0.0d;
    double EHighForAge = 0.0d;
    
    double Es = 0.0d;
    
    public UserInterface() {
        initComponents();
    }
    
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Predictive Analysis of Diabetic Patient Data Using Machine Learning and Hadoop");

        jButton2.setText("click to run");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(317, 317, 317))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
    {
    	try
    	{
	        FileInputStream fis = new FileInputStream("C:\\Work Material\\Daibetic Decesion Tree\\Training Set.txt");
	        byte bb[]=new byte[fis.available()];
	        fis.read(bb);
	        fis.close();
	        String fdata = new String(bb);
	        System.out.println(fdata);
	        
	        String attributes = "GLUCOSE,BP,PEDIGREE,AGE";
	        
	        System.out.println("\n\n******************************************************************* Computing ROOT Node *******************************************************************");
	        Node<String> root = createTree(fdata, attributes);
	        
	        prediction(root);
	        
	    }catch(Exception e )
    	{
	        System.out.println(e);
	    }
    }
    
    private void prediction(Node<String> root)
    {
    	try
    	{
	    	 System.out.println("\nEnter a Data Instance to predict:\n");
	    	 String dataInstance = "10,168,74,0,0,38.0,0.537,34,1";
		     System.out.println("\n" + dataInstance + "\n");
		     String prediction = traverseTree(root, dataInstance);
		     System.out.println("\n" + "Prediction = " + prediction + "\n");
		     
		     FileInputStream fis = new FileInputStream("C:\\Work Material\\Daibetic Decesion Tree\\Test Set.txt");
		     byte bb[]=new byte[fis.available()];
		     fis.read(bb);
		     fis.close();
		     String fdata = new String(bb);
		     
		     StringTokenizer data = new StringTokenizer(fdata,"\n\r");
		     int correct = 0, total = data.countTokens();
		     
		     while(data.hasMoreTokens())
		     {
		      	String line = data.nextToken();
		       	
		       	prediction = traverseTree(root, line);
		       	String label = getItem(line, 8);
		       	
		       	if(label.equals("1"))
		       		if(prediction.equals("YES"))
		       			correct++;
		       	
		       	if(label.equals("0"))
		       		if(prediction.equals("NO"))
		       			correct++;
		      }
		        
		      System.out.println("\nTotal Instances = " + total);
		      System.out.println("\nCorrect Predictions = " + correct);
		      float precesion = ((float)correct/(float)total)*100;
		      System.out.println("\nAlgorithm Precesion = " + precesion + "%");
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }
    
    private String traverseTree(Node<String> node, String dataInstance)
    {
    	String data = node.getData();
    	if(data.equals("YES") || data.equals("NO"))
    		return data;
    	
    	if(data.equals("GLUCOSE"))
    	{
    		float val = Float.parseFloat(getItem(dataInstance, 1));
    		List<Node<String>> children = node.getChildren();
    		
    		if(val < 95)
    			return traverseTree(children.get(0), dataInstance);
    		else if(val >= 95 && val <= 141)
    			return traverseTree(children.get(1), dataInstance);
    		else
    			return traverseTree(children.get(2), dataInstance);
    	}
    	
    	if(data.equals("BP"))
    	{
    		float val = Float.parseFloat(getItem(dataInstance, 2));
    		List<Node<String>> children = node.getChildren();
    		
    		if(val < 80)
    			return traverseTree(children.get(0), dataInstance);
    		else if(val >= 80 && val <= 90)
    			return traverseTree(children.get(1), dataInstance);
    		else
    			return traverseTree(children.get(2), dataInstance);
    	}
    	
    	if(data.equals("PEDIGREE"))
    	{
    		float val = Float.parseFloat(getItem(dataInstance, 6));
    		List<Node<String>> children = node.getChildren();
    		
    		if(val < 0.42)
    			return traverseTree(children.get(0), dataInstance);
    		else if(val >= 0.42 && val <= 0.82)
    			return traverseTree(children.get(1), dataInstance);
    		else
    			return traverseTree(children.get(2), dataInstance);
    	}
    	
    	if(data.equals("AGE"))
    	{
    		float val = Float.parseFloat(getItem(dataInstance, 7));
    		List<Node<String>> children = node.getChildren();
    		
    		if(val < 40)
    			return traverseTree(children.get(0), dataInstance);
    		else if(val >= 40 && val <= 60)
    			return traverseTree(children.get(1), dataInstance);
    		else
    			return traverseTree(children.get(2), dataInstance);
    	}
    	
    	return "Invalid DataInstance Input";
    }
    
    private Node<String> createTree(String dataset, String attributes)
    {
    	Node<String> node = new Node<String>("");
    	
    	if(dataset.equals(""))
    	{
    		//System.out.println("\nYES count = 0");
    		//System.out.println("\nNO count = 0");
    		System.out.println("\nNo LEAF NODE attached to Tree");
    		node.setData("No Data");
    		return node;
    	}
    	
        StringTokenizer data = new StringTokenizer(dataset,"\n");
		int y = 0, n = 0, ctr = 0;
		
		while(data.hasMoreTokens())
		{
			String line = data.nextToken();
			int val = Integer.parseInt(getItem(line, 8).trim());
			if(val == 0)
				n++;
			else
				y++;
		}
		
		if(n == 0)
		{
			//System.out.println("\nYES count = " + y);
			//System.out.println("\nNO count = " + n);
			System.out.println("\nLEAF NODE 'YES' attached to Tree");
			node.setData("YES");
			return node;
		}
		if(y == 0)
		{
			//System.out.println("\nYES count = " + y);
			//System.out.println("\nNO count = " + n);
			System.out.println("\nLEAF NODE 'NO' attached to Tree");
			node.setData("NO");
			return node;
		}
	
	    for(int i=0; i<4; i++)
	    {
	    	String temp = getItem(attributes,i);
	        if(temp.equals(" "))
	        	ctr++;
	    }
	
		if(ctr == 4)
		{
			if(y >= n)
			{
				//System.out.println("\nYES count = " + y);
				//System.out.println("\nNO count = " + n);
				System.out.println("\nLEAF NODE 'YES' attached to Tree");
				node.setData("YES");
				return node;
			}
			else
			{
				//System.out.println("\nYES count = " + y);
				//System.out.println("\nNO count = " + n);
				System.out.println("\nLEAF NODE 'NO' attached to Tree");
				node.setData("NO");
				return node;
			}
		}
	        
		String root = nodeCompute(dataset, attributes);
    	node.setData(root);
    	
    	String attriNew = attriFilter(attributes, root);
    	
    	System.out.println("\n\n**************************************************************** Computing Node for " + root + ": Low Branch ****************************************************************");
    	String dataLow = dataFilter(dataset, root, 0);
    	Node<String> nodeLow = createTree(dataLow, attriNew);
    	if(!nodeLow.getData().equals("No Data"))
    		node.addChild(nodeLow);
    	
    	System.out.println("\n\n************************************************************** Computing Node for " + root + ": Medium Branch **************************************************************");
    	String dataMed = dataFilter(dataset, root, 1);
    	Node<String> nodeMed = createTree(dataMed, attriNew);
    	if(!nodeMed.getData().equals("No Data"))
    		node.addChild(nodeMed);
    	
    	System.out.println("\n\n**************************************************************** Computing Node for " + root + ": High Branch ****************************************************************");
    	String dataHigh = dataFilter(dataset, root, 2);
    	Node<String> nodeHigh = createTree(dataHigh, attriNew);
    	if(!nodeHigh.getData().equals("No Data"))
    		node.addChild(nodeHigh);
        
        return node;
    }
    
    private String dataFilter(String dataset, String node, int stat)
    {
	// 0 = low, 1 = med, 2 = high
    	String newData = "";
        ArrayList<Float> one = new ArrayList<Float>();
        ArrayList<Float> two = new ArrayList<Float>();
        ArrayList<Float> three = new ArrayList<Float>();
        ArrayList<Float> four = new ArrayList<Float>();
        ArrayList<Float> five = new ArrayList<Float>();
        ArrayList<Float> six = new ArrayList<Float>();
        ArrayList<Float> seven = new ArrayList<Float>();
        ArrayList<Float> eight = new ArrayList<Float>();
        ArrayList<Integer> nine = new ArrayList<Integer>();
        // 2, 3, 7, 8 = Glucose, BP, Pedigree, Age
        
    	String row = "";
		StringTokenizer data = new StringTokenizer(dataset,"\r\n");
		while(data.hasMoreTokens())
		{
      		row = data.nextToken();
     		StringTokenizer vals=new StringTokenizer(row, ",");
     		while(vals.hasMoreTokens())
     		{
         			one.add(Float.parseFloat(vals.nextToken()));
         			two.add(Float.parseFloat(vals.nextToken()));
         			three.add(Float.parseFloat(vals.nextToken()));
         			four.add(Float.parseFloat(vals.nextToken()));
         			five.add(Float.parseFloat(vals.nextToken()));
         			six.add(Float.parseFloat(vals.nextToken()));
         			seven.add(Float.parseFloat(vals.nextToken()));
         			eight.add(Float.parseFloat(vals.nextToken()));
         			nine.add(Integer.parseInt(vals.nextToken()));
     		}
		}
    	
        if(stat == 0)
        {
            if(node.equals("GLUCOSE"))
            {
                for(int i=0;i<two.size();i++)
                {
                      float val = two.get(i);
                      if(val<95)
                      {
                           String line="";
                           line += one.get(i)+",";
                           line += two.get(i)+",";
                           line += three.get(i)+",";
                           line += four.get(i)+",";
                           line += five.get(i)+",";
                           line += six.get(i)+",";
                           line += seven.get(i)+",";
                           line += eight.get(i)+",";
                           line += nine.get(i)+",";
                           
                           newData += line+"\n";
                      }
                }
            }
            else if(node.equals("BP"))
            {
                for(int i=0;i<three.size();i++)
                {
                      float val = three.get(i);
                      if(val<80)
                      {
                          String line="";
                           line += one.get(i)+",";
                           line += two.get(i)+",";
                           line += three.get(i)+",";
                           line += four.get(i)+",";
                           line += five.get(i)+",";
                           line += six.get(i)+",";
                           line += seven.get(i)+",";
                           line += eight.get(i)+",";
                           line += nine.get(i)+",";
                           
                           newData += line+"\n";
                      }
                }
            }
            else if(node.equals("PEDIGREE"))
            {
                for(int i=0;i<seven.size();i++)
                {
                      float val = seven.get(i);
                      if(val<0.42)
                      {
                          String line="";
                           line += one.get(i)+",";
                           line += two.get(i)+",";
                           line += three.get(i)+",";
                           line += four.get(i)+",";
                           line += five.get(i)+",";
                           line += six.get(i)+",";
                           line += seven.get(i)+",";
                           line += eight.get(i)+",";
                           line += nine.get(i)+",";
                           
                           newData += line+"\n";
                      }
                }
            }
            else if(node.equals("AGE"))
            {
                for(int i=0;i<eight.size();i++)
                {
                      float val = eight.get(i);
                      if(val<40)
                      {
                          String line="";
                           line += one.get(i)+",";
                           line += two.get(i)+",";
                           line += three.get(i)+",";
                           line += four.get(i)+",";
                           line += five.get(i)+",";
                           line += six.get(i)+",";
                           line += seven.get(i)+",";
                           line += eight.get(i)+",";
                           line += nine.get(i)+",";
                           
                           newData += line+"\n";
                      }
                }
            }
        }
        else if(stat == 1)
        {
            if(node.equals("GLUCOSE"))
            {
                for(int i=0;i<two.size();i++)
                {
                      float val = two.get(i);
                      if(val>=95 && val<=141)
                      {
                          String line="";
                           line += one.get(i)+",";
                           line += two.get(i)+",";
                           line += three.get(i)+",";
                           line += four.get(i)+",";
                           line += five.get(i)+",";
                           line += six.get(i)+",";
                           line += seven.get(i)+",";
                           line += eight.get(i)+",";
                           line += nine.get(i)+",";
                           
                           newData += line+"\n";
                      }
                }
            }
            else if(node.equals("BP"))
            {
                for(int i=0;i<three.size();i++)
                {
                      float val = three.get(i);
                      if(val>=80 && val<=90)
                      {
                          String line="";
                           line += one.get(i)+",";
                           line += two.get(i)+",";
                           line += three.get(i)+",";
                           line += four.get(i)+",";
                           line += five.get(i)+",";
                           line += six.get(i)+",";
                           line += seven.get(i)+",";
                           line += eight.get(i)+",";
                           line += nine.get(i)+",";
                           
                           newData += line+"\n";
                      }
                }
            }
            else if(node.equals("PEDIGREE"))
            {
                for(int i=0;i<seven.size();i++)
                {
                      float val = seven.get(i);
                      if(val>=0.42 && val<=0.82)
                      {
                          String line="";
                           line += one.get(i)+",";
                           line += two.get(i)+",";
                           line += three.get(i)+",";
                           line += four.get(i)+",";
                           line += five.get(i)+",";
                           line += six.get(i)+",";
                           line += seven.get(i)+",";
                           line += eight.get(i)+",";
                           line += nine.get(i)+",";
                           
                           newData += line+"\n";
                      }
                }
            }
            else if(node.equals("AGE"))
            {
                for(int i=0;i<eight.size();i++)
                {
                      float val = eight.get(i);
                      if(val>=40 && val<=60)
                      {
                          String line="";
                           line += one.get(i)+",";
                           line += two.get(i)+",";
                           line += three.get(i)+",";
                           line += four.get(i)+",";
                           line += five.get(i)+",";
                           line += six.get(i)+",";
                           line += seven.get(i)+",";
                           line += eight.get(i)+",";
                           line += nine.get(i)+",";
                           
                           newData += line+"\n";
                      }
                }
            }
        }
        else
        {
            if(node.equals("GLUCOSE"))
            {
                for(int i=0;i<two.size();i++)
                {
                      float val = two.get(i);
                      if(val>141)
                      {
                          String line="";
                           line += one.get(i)+",";
                           line += two.get(i)+",";
                           line += three.get(i)+",";
                           line += four.get(i)+",";
                           line += five.get(i)+",";
                           line += six.get(i)+",";
                           line += seven.get(i)+",";
                           line += eight.get(i)+",";
                           line += nine.get(i)+",";
                           
                           newData += line+"\n";
                      }
                }
            }
            else if(node.equals("BP"))
            {
                for(int i=0;i<three.size();i++)
                {
                      float val = three.get(i);
                      if(val>90)
                      {
                          String line="";
                           line += one.get(i)+",";
                           line += two.get(i)+",";
                           line += three.get(i)+",";
                           line += four.get(i)+",";
                           line += five.get(i)+",";
                           line += six.get(i)+",";
                           line += seven.get(i)+",";
                           line += eight.get(i)+",";
                           line += nine.get(i)+",";
                           
                           newData += line+"\n";
                      }
                }
            }
            else if(node.equals("PEDIGREE"))
            {
                for(int i=0;i<seven.size();i++)
                {
                      float val = seven.get(i);
                      if(val>0.82)
                      {
                          String line="";
                           line += one.get(i)+",";
                           line += two.get(i)+",";
                           line += three.get(i)+",";
                           line += four.get(i)+",";
                           line += five.get(i)+",";
                           line += six.get(i)+",";
                           line += seven.get(i)+",";
                           line += eight.get(i)+",";
                           line += nine.get(i)+",";
                           
                           newData += line+"\n";
                      }
                }
            }
            else if(node.equals("AGE"))
            {
                for(int i=0;i<eight.size();i++)
                {
                      float val = eight.get(i);
                      if(val>60)
                      {
                          String line="";
                           line += one.get(i)+",";
                           line += two.get(i)+",";
                           line += three.get(i)+",";
                           line += four.get(i)+",";
                           line += five.get(i)+",";
                           line += six.get(i)+",";
                           line += seven.get(i)+",";
                           line += eight.get(i)+",";
                           line += nine.get(i)+",";
                           
                           newData += line+"\n";
                      }
                }
            }
        }

    	return newData;
    }
    
    private String attriFilter(String attributes, String node)
    {
    	String newAttri = "";
        
        for(int i=0; i<4; i++)
        {
            String temp = getItem(attributes,i);
            if(temp.equals(node))
                newAttri += " " + ",";
            else
                newAttri += temp + ",";
        }
        
    	return newAttri;
    }
    
    private String getItem(String str, int pos)
    {
    	StringTokenizer st = new StringTokenizer(str, ",");
    	for(int i=0; i<pos; i++)
    		st.nextToken();
    	return st.nextToken();
    }
    
    private String nodeCompute(String fdata, String attributes) {                                         
        try{
        	
        	SplitConsoldationRatio.clear();
        	GainConsoldationRatio.clear(); 
	        firstS.clear();
	        secondS.clear();
	        thirdS.clear();
	        fourthS.clear();
	        fifthS.clear();
	        sixthS.clear();
	        seventhS.clear();
	        eigthS.clear();
	        ninthS.clear();
	        
	        firstF.clear();
	        secondF.clear();
	        thirdF.clear();
	        fourthF.clear();
	        fifthF.clear();
	        sixthF.clear();
	        seventhF.clear();
	        eigthF.clear();
	        ninthF.clear();
	        
	        glucoseLow = 0;
	        glucoseMed = 0;
	        glucosehigh=0;
	        
	        bpLow = 0;
	        bpMed = 0;
	        bphigh=0;
	        
	        pedigreeLow = 0;
	        pedigreeMed = 0;
	        pedigreehigh=0;
	        
	        ageLow = 0;
	        ageMed = 0;
	        agehigh=0;
	        
	        //glucose
	        glLowYes = 0;    
	        glMedYes = 0;
	        glHighYes = 0; 
	        
	        glLowNo = 0;    
	        glMedNo = 0;
	        glHighNo = 0; 
	        
	        //BP
	        bpLowYes = 0;    
	        bpMedYes = 0;
	        bpHighYes = 0;
	        
	        bpLowNo = 0;    
	        bpMedNo = 0;
	        bpHighNo = 0;
	        
	        //pedigre
	        pdLowYes = 0;    
	        pdMedYes = 0;
	        pdHighYes = 0; 
	        
	        pdLowNo = 0;    
	        pdMedNo = 0;
	        pdHighNo = 0; 
	      
	       //age
	        ageLowYes = 0;    
	        ageMedYes = 0;
	        ageHighYes = 0;
	        
	        ageLowNo = 0;    
	        ageMedNo = 0;
	        ageHighNo = 0;
	        
	        ElowForGlu = 0.0d;
	        EmedForGlu = 0.0d;
	        EHighForGlu = 0.0d;
	        
	        ElowForBp = 0.0d;
	        EmedForBp = 0.0d;
	        EHighForBp = 0.0d;
	        
	        ElowForPedigre = 0.0d;
	        EmedForPedigre = 0.0d;
	        EHighForPedigre = 0.0d;
	       
	        ElowForAge = 0.0d;
	        EmedForAge = 0.0d;
	        EHighForAge = 0.0d;
	        
	        Es = 0.0d;
        	
    String fdata1="";
    StringTokenizer str=new StringTokenizer(fdata,"\r\n");
    while(str.hasMoreTokens())
    {
          fdata1=str.nextToken();
         StringTokenizer str1=new StringTokenizer(fdata1,",");
         while(str1.hasMoreTokens())
         {
             firstS.add(str1.nextToken());
             secondS.add(str1.nextToken());
             thirdS.add(str1.nextToken());
             fourthS.add(str1.nextToken());
             fifthS.add(str1.nextToken());
             sixthS.add(str1.nextToken());
             seventhS.add(str1.nextToken());
             eigthS.add(str1.nextToken());
             ninthS.add(str1.nextToken());
         }
    }

    int yesCount = Collections.frequency(ninthS, "1");
    int noCount = Collections.frequency(ninthS, "0");
    System.out.println("Yes:  "+yesCount+" "+" No:"+noCount);
    System.out.println("Total:"+firstS.size());
    System.out.println();
    
    for(int i=0;i<firstS.size();i++){
        String sData = firstS.get(i).toString().trim();
        float fData = Float.parseFloat(sData);
        firstF.add(fData);
    }
    
     for(int i=0;i<secondS.size();i++){
        String sData = secondS.get(i).toString().trim();
        float fData = Float.parseFloat(sData);
        secondF.add(fData);
    }
    
     for(int i=0;i<thirdS.size();i++){
        String sData = thirdS.get(i).toString().trim();
        float fData = Float.parseFloat(sData);
        thirdF.add(fData);
    }
     
     for(int i=0;i<fourthS.size();i++){
        String sData = fourthS.get(i).toString().trim();
        float fData = Float.parseFloat(sData);
        fourthF.add(fData);
    }
      
       for(int i=0;i<fifthS.size();i++){
        String sData = fifthS.get(i).toString().trim();
        float fData = Float.parseFloat(sData);
        fifthF.add(fData);
    }
       
        for(int i=0;i<sixthS.size();i++){
        String sData = sixthS.get(i).toString().trim();
        float fData = Float.parseFloat(sData);
        sixthF.add(fData);
    }
        
        for(int i=0;i<seventhS.size();i++){
        String sData = seventhS.get(i).toString().trim();
        float fData = Float.parseFloat(sData);
        seventhF.add(fData);
    }
         
        for(int i=0;i<eigthS.size();i++){
        String sData =eigthS.get(i).toString().trim();
        float fData = Float.parseFloat(sData);
        eigthF.add(fData);
    }
          
        for(int i=0;i<ninthS.size();i++){
        String sData = ninthS.get(i).toString().trim();
        float fData = Float.parseFloat(sData);
        ninthF.add(fData);
    }
      
       double first = (double)(yesCount/(double)(yesCount+noCount));
       double second = (Math.log((double)(yesCount/(double)(yesCount+noCount)))/
               Math.log(2));
       double third = (double)(noCount/(double)(yesCount+noCount));
       double fourth = (Math.log((double)(noCount/(double)(yesCount+noCount)))/
               Math.log(2));     
      
       Es = -(first*second) - (third*fourth);
       System.out.println("Entropy of the System[Entropy(S)]:"+Es);
       System.out.println();
        System.out.println("=========================================");
       //Es = (yesCount/(yesCount+noCount)) * Math.log2(yesCount/yesCount+noCount)-(noCount/(yesCount+noCount))*Math.log2(noCount/(yesCount+noCount));
       
        for(int i=0;i<secondS.size();i++){
              float gValue = secondF.get(i);
              if(gValue<95){
                  ++glucoseLow;
                  String ninthAtt = ninthS.get(i);
                  if(ninthAtt.equals("1")){
                     ++glLowYes; 
                  }else
                  {
                     ++glLowNo; 
                  }
              }
              else if(gValue>=95 && gValue<=141){
                  ++glucoseMed;
                  String ninthAtt = ninthS.get(i);
                  if(ninthAtt.equals("1")){
                     ++glMedYes; 
                  }else
                  {
                     ++glMedNo; 
                  }
              }
              else {
                  ++glucosehigh;
                  String ninthAtt = ninthS.get(i);
                  if(ninthAtt.equals("1")){
                     ++glHighYes; 
                  }
                  else 
                  {
                      ++glHighNo;
                  }
              }
          }
          double TotalForGlu = 0.0d; 
          TotalForGlu=glucoseLow+glucoseMed+glucosehigh;
          
          double glulowp1 = 0.0d;
          glulowp1=glucoseLow/TotalForGlu;
          
          double glumedp1 = 0.0d;
          glumedp1=glucoseMed/TotalForGlu;
          
          double gluhighp1 = 0.0d;
          gluhighp1=glucosehigh/TotalForGlu;
            
            System.out.println("         L"+"   M"+"   H");
            System.out.println("Glucose:"+glucoseLow+" "+glucoseMed+" "+glucosehigh);
            System.out.println("Yes:    "+glLowYes+" "+glMedYes+" "+glHighYes);
            System.out.println("No:     "+glLowNo+" "+glMedNo+" "+glHighNo);
            System.out.println();
            System.out.println("T(s,v)/Ts [s=Glucose]:"+glulowp1+" "+glumedp1+" "+gluhighp1);
            System.out.println("=========================================");
            for(int i=0;i<thirdS.size();i++){
              float gValue = thirdF.get(i);
              if(gValue<80){
                  ++bpLow;
                  String ninthAtt = ninthS.get(i);
                  if(ninthAtt.equals("1")){
                     ++bpLowYes; 
                  }else
                  {
                     ++bpLowNo; 
                  }
              }
              else if(gValue>=80 && gValue<=90){
                  ++bpMed;
                  String ninthAtt = ninthS.get(i);
                  if(ninthAtt.equals("1")){
                     ++bpMedYes; 
                  }else
                  {
                     ++bpMedNo; 
                  }
              }
              else {
                  ++bphigh;
                  String ninthAtt = ninthS.get(i);
                  if(ninthAtt.equals("1")){
                     ++bpHighYes; 
                  }else
                  {
                     ++bpHighNo; 
                  }
              }
          }
          double TotalForBP = 0.0d; 
          TotalForBP=bpLow+bpMed+bphigh;
          
          double bplowp1 = 0.0d;
          bplowp1=bpLow/TotalForBP;
          
          double bpmedp1 = 0.0d;
          bpmedp1=bpMed/TotalForBP;
         
          double bphighp1 = 0.0d;
          bphighp1=bphigh/TotalForBP;
            System.out.println("    L"+"   M"+"   H");
            System.out.println("Bp: "+bpLow+" "+ bpMed+" "+bphigh);
            System.out.println("Yes:"+bpLowYes+" "+bpMedYes+" "+bpHighYes);
            System.out.println("No: "+bpLowNo+" "+bpMedNo+" "+bpHighNo);
            System.out.println();
            System.out.println("(T(s,v)/Ts [s=Bp]:"+bplowp1+" "+bpmedp1+" "+bphighp1);
            
            System.out.println("=========================================");
            for(int i=0;i<seventhS.size();i++){
              float gValue = seventhF.get(i);
              if(gValue<0.42){
                  ++pedigreeLow;
                  String ninthAtt = ninthS.get(i);
                  if(ninthAtt.equals("1")){
                     ++pdLowYes; 
                  }else
                  {
                     ++pdLowNo; 
                  }
                }
              else if(gValue>=0.42 && gValue<=0.82){
                  ++pedigreeMed;
                  String ninthAtt = ninthS.get(i);
                  if(ninthAtt.equals("1")){
                     ++pdMedYes; 
                  }else
                  {
                     ++pdMedNo; 
                  }
              }
              else {
                  ++pedigreehigh;
                  String ninthAtt = ninthS.get(i);
                  if(ninthAtt.equals("1")){
                     ++pdHighYes; 
                  }else
                  {
                     ++pdHighNo; 
                  }
              }
          }
          double TotalForPD = 0.0d; 
          TotalForPD=pedigreeLow+pedigreeMed+pedigreehigh;
          
          double pdlowp1 = 0.0d;
          pdlowp1=pedigreeLow/TotalForPD;
          
          double pdmedp1 = 0.0d;
          pdmedp1=pedigreeMed/TotalForPD;
         
          double pdhighp1 = 0.0d;
          pdhighp1=pedigreehigh/TotalForPD;
            System.out.println("          L"+"   M"+"   H");
            System.out.println("Pedigree: "+pedigreeLow+" "+pedigreeMed+" "+pedigreehigh);
            System.out.println("Yes:      "+pdLowYes+" "+pdMedYes+" "+pdHighYes);
            System.out.println("No:       "+pdLowNo+" "+pdMedNo+" "+pdHighNo);
            System.out.println();
            System.out.println("(T(s,v)/Ts [s=Pedigree]:"+pdlowp1+" "+pdmedp1+" "+pdhighp1);
            
            System.out.println("=========================================");
            for(int i=0;i<eigthS.size();i++){
              float gValue = eigthF.get(i);
              if(gValue<40){
                  ++ageLow;
                   String ninthAtt = ninthS.get(i);
                  if(ninthAtt.equals("1")){
                     ++ageLowYes; 
                  }else
                  {
                     ++ageLowNo; 
                  }
              }
              else if(gValue>=40 && gValue<=60){
                  ++ageMed;
                   String ninthAtt = ninthS.get(i);
                  if(ninthAtt.equals("1")){
                     ++ageMedYes; 
                  }else
                  {
                     ++ageMedNo; 
                  }
              }
              else {
                  ++agehigh;
                  String ninthAtt = ninthS.get(i);
                  if(ninthAtt.equals("1")){
                     ++ageHighYes; 
                  }else
                  {
                     ++ageHighNo; 
                  }
              }
          }
          double TotalForAGE = 0.0d; 
          TotalForAGE=ageLow+ageMed+agehigh;
          
          double agelowp1 = 0.0d;
          agelowp1=ageLow/TotalForAGE;
          
          double agemedp1 = 0.0d;
          agemedp1=ageMed/TotalForAGE;
          
          double agehighp1 = 0.0d;
          agehighp1=agehigh/TotalForAGE;
             System.out.println("      L"+"   M"+"   H");
             System.out.println("Age: "+ageLow+" "+ageMed+" "+agehigh);
             System.out.println("Yes: "+ageLowYes+" "+ageMedYes+" "+ageHighYes);
             System.out.println("No:  "+ageLowNo+" "+ageMedNo+" "+ageHighNo);
             System.out.println();
             System.out.println("(T(s,v)/Ts [s=Age]:"+agelowp1+" "+agemedp1+" "+agehighp1);
            
          System.out.println("=========================================");
 
            //Entropy  Glucose
            EntropyIndividual EpLowGlu = new EntropyIndividual();
            ElowForGlu = EpLowGlu.getEntroy(glLowYes,glLowNo,glucoseLow);
            EntropyIndividual EpMedGlu = new EntropyIndividual();
            EmedForGlu = EpMedGlu.getEntroy(glMedYes,glMedNo,glucoseMed);
            EntropyIndividual EpHighGlu = new EntropyIndividual();
            EHighForGlu = EpHighGlu.getEntroy(glHighYes,glHighNo,glucosehigh);
            System.out.println(            "                L"+"                   M"+"                   H");          
            System.out.println("Entropy Glucose:"+ElowForGlu+" "+EmedForGlu+" "+EHighForGlu);
          System.out.println("=========================================");
            
             //Entropy  Bp
            EntropyIndividual EpLowBp = new EntropyIndividual();
            ElowForBp = EpLowBp.getEntroy(bpLowYes,bpLowNo,bpLow);
            EntropyIndividual EpMedBp = new EntropyIndividual();
            EmedForBp = EpMedBp.getEntroy(bpMedYes,bpMedNo,bpMed);
            EntropyIndividual EpHighBp = new EntropyIndividual();
            EHighForBp = EpHighBp.getEntroy(bpHighYes,bpHighNo,bphigh);  
            System.out.println(          "             L"+"                 M"+"                 H");  
            System.out.println("Entropy BP:"+ElowForBp+" "+EmedForBp+" "+EHighForBp);
            System.out.println("=========================================");
            
           //Entropy  Pedigree
            EntropyIndividual EpLowPed = new EntropyIndividual();
            ElowForPedigre  = EpLowPed.getEntroy(pdLowYes,pdLowNo,pedigreeLow);
            EntropyIndividual EpMedPed = new EntropyIndividual();
            EmedForPedigre  = EpMedPed.getEntroy(pdMedYes,pdMedNo,pedigreeMed);
            EntropyIndividual EpHighPed = new EntropyIndividual();
            EHighForPedigre   = EpHighPed.getEntroy(pdHighYes,pdHighNo,pedigreehigh); 
            System.out.println(             "                   L"+"                M"+"                   H");  
            System.out.println("Entropy Pedigree:"+ElowForPedigre+" "+EmedForPedigre+" "+EHighForPedigre);
            System.out.println("=========================================");
            
            //Entropy  Age
            EntropyIndividual EpLowAge = new EntropyIndividual();
            ElowForAge  = EpLowAge.getEntroy(ageLowYes,ageLowNo,ageLow);
            EntropyIndividual EpMedAge = new EntropyIndividual();
            EmedForAge  = EpMedAge.getEntroy(ageMedYes,ageMedNo,ageMed);
            EntropyIndividual EpHighAge = new EntropyIndividual();
            EHighForAge   = EpHighAge.getEntroy(ageHighYes,ageHighNo,agehigh);  
            System.out.println(          "               L"+"                 M"+"               H"); 
            System.out.println("Entropy Age:"+ElowForAge+" "+EmedForAge+" "+EHighForAge);
            System.out.println("=========================================");
           
            // Gain Glucose
            EntropyGainCalculation GainGlucose = new EntropyGainCalculation();
            GainConsoldationRatio.add(GainGlucose.getEntropyGain(Es,ElowForGlu ,EmedForGlu ,EHighForGlu,glulowp1,glumedp1,gluhighp1));
            System.out.println("GainGlucose :"+GainGlucose.getEntropyGain(Es,ElowForGlu ,EmedForGlu ,EHighForGlu,glulowp1,glumedp1,gluhighp1));
            
            EntropyGainCalculation GainBp = new EntropyGainCalculation();
            GainConsoldationRatio.add(GainBp.getEntropyGain(Es,ElowForBp ,EmedForBp ,EHighForBp,bplowp1,bpmedp1,bphighp1));
            System.out.println("GainBp :"+GainBp.getEntropyGain(Es,ElowForBp ,EmedForBp ,EHighForBp,bplowp1,bpmedp1,bphighp1));
            
            EntropyGainCalculation GainPedigree = new EntropyGainCalculation();
            GainConsoldationRatio.add(GainPedigree.getEntropyGain(Es,ElowForPedigre ,EmedForPedigre ,EHighForPedigre,pdlowp1,pdmedp1,pdhighp1));
            System.out.println("GainPedigree :"+GainPedigree.getEntropyGain(Es,ElowForPedigre ,EmedForPedigre ,EHighForPedigre,pdlowp1,pdmedp1,pdhighp1));
            
           EntropyGainCalculation GainAge = new EntropyGainCalculation();
           GainConsoldationRatio.add(GainAge.getEntropyGain(Es,ElowForAge ,EmedForAge ,EHighForAge,agelowp1,agemedp1,agehighp1));
           System.out.println("GainAge:"+GainAge.getEntropyGain(Es,ElowForAge ,EmedForAge ,EHighForAge,agelowp1,agemedp1,agehighp1));
           
           System.out.println("=========================================");
           
            //SplitInfo  
           
            SplitInfo siGlu=new SplitInfo();
            SplitConsoldationRatio.add(siGlu.getSplitInfo(TotalForGlu, glucoseLow, glucoseMed, glucosehigh));
            Double splitInfoGlu=siGlu.getSplitInfo(TotalForGlu, glucoseLow, glucoseMed, glucosehigh);
            System.out.println("SpitInfoGlu :"+splitInfoGlu);
            
            SplitInfo siBP=new SplitInfo();
            SplitConsoldationRatio.add(siBP.getSplitInfo(TotalForBP, bpLow, bpMed, bphigh));
            Double splitInfoBP=siBP.getSplitInfo(TotalForBP, bpLow, bpMed, bphigh);
            System.out.println("SpitInfoBP :"+splitInfoBP); 
            
            SplitInfo siPD=new SplitInfo();
            SplitConsoldationRatio.add(siPD.getSplitInfo(TotalForPD,pedigreeLow, pedigreeMed, pedigreehigh));
            Double splitInfoPd=siPD.getSplitInfo(TotalForPD, pedigreeLow, pedigreeMed, pedigreehigh);
            System.out.println("SpitInfoPed :"+splitInfoPd);

            SplitInfo siAge=new SplitInfo();
            SplitConsoldationRatio.add(siAge.getSplitInfo(TotalForAGE, ageLow, ageMed, agehigh));
            Double splitInfoAge=siAge.getSplitInfo(TotalForAGE, ageLow, ageMed, agehigh);
            System.out.println("SpitInfoAge :"+splitInfoAge);
            System.out.println("================================="); 

            System.out.println("================================="); 
              
            System.out.println("GainConsoldationRatio  :"+GainConsoldationRatio);
            System.out.println("=========================================");
            
            System.out.println("SplitConsoldationRatio  :"+SplitConsoldationRatio);
            System.out.println("=========================================");
           
            ArrayList<Double> allGainRatio = new ArrayList<Double>();
            allGainRatio.clear();
            for(int i=0;i<GainConsoldationRatio.size();i++){
                double valueRoot = (double) GainConsoldationRatio.get(i)/SplitConsoldationRatio.get(i);
                allGainRatio.add(valueRoot);
            }
            
            System.out.println("GainRatio             :"+allGainRatio);
            System.out.println("=====================");
            
            int highIndex = -1;
            while(true)
            {
            	double highGainRatio = Collections.max(allGainRatio);
            	highIndex = allGainRatio.indexOf(highGainRatio);
            	
            	if(getItem(attributes, highIndex).equals(" "))
            	{
            		allGainRatio.remove(highIndex);
            		allGainRatio.add(highIndex, -99999.0);
            	}
            	else
            		break;
            }
            
            String highGainRatioAttr = getItem(attributes, highIndex);
            return highGainRatioAttr;
       }catch(Exception e ){
           e.printStackTrace();
       }
        return "";
    }

    public static void main(String args[]) {
       
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}