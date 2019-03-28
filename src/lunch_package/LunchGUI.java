package lunch_package;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

public class LunchGUI extends JFrame {

    Container container;
    JPanel leftPanel,rightPanel,leftNorthPanel,rightCenterPanel,rightSouthPanel;
    JScrollPane leftCenterPanel;
    JButton all,korean,japanese,western,chinese,etc,add,clear,random,menuL;
    JLabel name,kind,recoMenu,menuLink;
    JTextField fname,fkind,frecoMenu;
    JList<String> jlist;
    List<Restaurant> data;
    DefaultListModel defaultListModel = null;
    Restaurant restaurant;

    public LunchGUI(){
        this.setTitle("종로 식당");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int w = 800;
        int h = 300;
        int width = dimension.width;
        int height = dimension.height;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds((width-w)/2,(height-h)/2,w,h);

        container = getContentPane();
        defaultListModel = new DefaultListModel();
        jlist = new JList(defaultListModel);
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        leftNorthPanel = new JPanel();
        rightCenterPanel = new JPanel();
        rightSouthPanel = new JPanel();
        leftCenterPanel = new JScrollPane(jlist);


        all = new JButton("전체");
        korean = new JButton("한식");
        japanese = new JButton("일식");
        western = new JButton("양식");
        chinese = new JButton("중식");
        etc = new JButton("기타");
        add = new JButton("추가");
        clear = new JButton("초기화");
        random = new JButton("랜덤");
        menuL = new JButton("식당정보(메뉴)");

        name = new JLabel("이름",JLabel.LEFT);
        kind = new JLabel("종류",JLabel.LEFT);
        recoMenu = new JLabel("추천메뉴",JLabel.LEFT);
        menuLink = new JLabel("메뉴링크",JLabel.LEFT);

        fname = new JTextField();
        fkind = new JTextField();
        frecoMenu = new JTextField();

        EventHandler handler = new EventHandler(this);

        this.setVisible(true);
        this.setResizable(false);

        all.addActionListener(handler);
        korean.addActionListener(handler);
        japanese.addActionListener(handler);
        western.addActionListener(handler);
        chinese.addActionListener(handler);
        etc.addActionListener(handler);
        add.addActionListener(handler);
        clear.addActionListener(handler);
        random.addActionListener(handler);
        menuL.addActionListener(handler);
        jlist.addListSelectionListener(handler);
    }

    public void display(){
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBorder(new TitledBorder("식당리스트"));
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBorder(new TitledBorder("식당정보"));

        leftNorthPanel.setLayout(new GridLayout(1,6,3,3));
        leftNorthPanel.add(all);
        leftNorthPanel.add(korean);
        leftNorthPanel.add(chinese);
        leftNorthPanel.add(japanese);
        leftNorthPanel.add(western);
        leftNorthPanel.add(etc);

        leftPanel.add("North",leftNorthPanel);
        leftPanel.add("Center",leftCenterPanel);

        rightCenterPanel.setLayout(new GridLayout(5,2,3,3));
        rightCenterPanel.add(name);
        rightCenterPanel.add(fname);
        rightCenterPanel.add(kind);
        rightCenterPanel.add(fkind);
        rightCenterPanel.add(recoMenu);
        rightCenterPanel.add(frecoMenu);
        rightCenterPanel.add(menuLink);
        rightCenterPanel.add(menuL);

        rightSouthPanel.setLayout(new GridLayout(1,3));
        rightSouthPanel.add(random);
        rightSouthPanel.add(add);
        rightSouthPanel.add(clear);

        rightPanel.add("Center",rightCenterPanel);
        rightPanel.add("South",rightSouthPanel);

        container.setLayout(new GridLayout(1,2));
        container.add(leftPanel);
        container.add(rightPanel);
    }

}
