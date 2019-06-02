/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayParadise;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Benedict
 */
public class CoursData 
{
    private static ArrayList<Course> courseList = new ArrayList<Course>();
    
    /**
     * returns the last id of the course wich has been created
     * @return id
     */
    public int getlastCourseId()
    {
        int id;
        
        id=-1;        
        for(int i=0;i< this.courseList.size();i++)
        {
            id=this.courseList.get(i).getCousrseID();
        }
        return id;        
    }
    
    /**
     * sets an course
     * @param pBeginingOfCourse
     * @param pCousrsName
     * @param pdateOfCourse
     * @param pEndOfCourse
     * @param pWeekday 
     */
    public void setCourseList(String pBeginingOfCourse, String pCousrsName, LocalDate pdateOfCourse, String pEndOfCourse, String pWeekday)
    {
        Course course = new Course();
        course.setBeginingOfCourse(pBeginingOfCourse);
        course.setCousrsName(pCousrsName);
        course.setDateOfCourse(pdateOfCourse);
        course.setEndOfCourse(pEndOfCourse);
        course.setWeekday(pWeekday);
        this.courseList.add(course);
    }
    
    /**
     * returs cours size mines one
     * @return size
     */
    public int getCourseListSize()
    {
        int size;
        size=courseList.size();
        size--;
        return size;
    }
    
    
    /**
     * fiels up the table in the mainFrame with alle the values of the ArraList
     */
    public static void getCoursList() {
        String col[] = {"ID", "Name", "Begin", "End", "Date", "Day"};
        DefaultTableModel model = new DefaultTableModel(col, 0) {
            public boolean isCellEditable(int row, int col) {
                //first column not editable
                if (col == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        Gui.MainFrame.coursTable.setModel(model);
        for (int i = 0; i < courseList.size(); i++) 
        {
            int id = courseList.get(i).getCousrseID();
            String name = courseList.get(i).getCousrsName();
            String start = courseList.get(i).getBeginingOfCourse();
            String end = courseList.get(i).getEndOfCourse();
            LocalDate date = courseList.get(i).getDateOfCourse();
            String dateAsString = String.valueOf(date);
            String day = courseList.get(i).getWeekday();
            Object[] item = {id, name, start, end, dateAsString, day};
            model.addRow(item);

        }
        
        TableModelListener modelListener = new TableModelListener() 
        {
            public void tableChanged(TableModelEvent evt) 
            {

                Boolean error = false;
                Pattern pattern;
                Matcher matcher;
                String regex="^(0[0-9]|1[0-9]|2[0-3]|[0-9]):[0-5][0-9]$"; 
                pattern = Pattern.compile(regex);
                LocalDate courseDate = null;
                try {
                    int rows = Gui.MainFrame.coursTable.getRowCount();

                    for (int row = 0; row < rows; row++) {
                        int id = (int) Gui.MainFrame.coursTable.getValueAt(row, 0);
                        String name = (String) Gui.MainFrame.coursTable.getValueAt(row, 1);
                        String begin = (String) Gui.MainFrame.coursTable.getValueAt(row, 2);
                        String end = (String) Gui.MainFrame.coursTable.getValueAt(row, 3);
                        String date = (String) Gui.MainFrame.coursTable.getValueAt(row, 4);
                        String day = (String) Gui.MainFrame.coursTable.getValueAt(row, 5);

                        courseDate = LocalDate.parse(date);

                        courseList.get(id).setCousrsName(name);
                        courseList.get(id).setDateOfCourse(courseDate);
                        courseList.get(id).setWeekday(day);
                        matcher=pattern.matcher(end);
                        if(!(matcher.find()&&matcher.group().equals(end)))
                        {
                            JOptionPane.showMessageDialog(new JFrame(), "Error, not saved. Please check Time HH:mm, Date YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else
                        {
                            courseList.get(id).setBeginingOfCourse(begin);
                        }
                        matcher=pattern.matcher(begin);
                        if(!(matcher.find()&&matcher.group().equals(begin)))
                        {
                            JOptionPane.showMessageDialog(new JFrame(), "Error, not saved. Please check Time HH:mm, Date YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else
                        {
                            courseList.get(id).setEndOfCourse(end);
                        }                        
                    }
                } catch (IndexOutOfBoundsException ex) {
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(new JFrame(), "Error, not saved. Please check Time HH:mm, Date YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println(e);
                    error = true;

                    if (error == false) {
                        System.out.println("Saving successfull");

                    }
                }
            }
        };
        model.addTableModelListener(modelListener);
    }

    /**
     * Method to change a course
     *
     * @param index
     * @param userInputOld
     * @param userInputNew
     */
    public void updateCourse(int index, String userInputOld, String userInputNew) 
    {
        LocalDate courseDateInput;
        
        switch (userInputOld) 
        {
            case "Name":
                this.courseList.get(index).setCousrsName(userInputNew);
                break;
                
            case "Start":
                this.courseList.get(index).setBeginingOfCourse(userInputNew);
                break;

            case "End":               
                this.courseList.get(index).setEndOfCourse(userInputNew);
                break;

            case "Date":
                try
                {
                    courseDateInput = LocalDate.parse(userInputNew);
                    this.courseList.get(index).setDateOfCourse(courseDateInput);
                }
                catch(Exception e)
                {
                  JOptionPane.showMessageDialog(null, "Date is incorrect!");
                }                
                break;

            case "Day":

                this.courseList.get(index).setWeekday(userInputNew);
                break;

            default:
                break;
        }
    }
    
    /**
     * delets the cours and removs it frome the Table
     */
    public static void delteCoursefromTable() 
    {        
        DefaultTableModel model2 = (DefaultTableModel) Gui.MainFrame.coursTable.getModel();
        int[] selectedRows = Gui.MainFrame.coursTable.getSelectedRows();
        if (selectedRows.length > 0) 
        {
            for (int i = selectedRows.length-1; i >= 0; i--) 
            {
                String idAsString = (Gui.MainFrame.coursTable.getValueAt(selectedRows[i], 0).toString());
                int id = Integer.valueOf(idAsString);
                for (int j = courseList.size()-1; j >= 0; j--) {
                    if (courseList.get(j).getCousrseID()== (id)) 
                    {                        
                        courseList.remove(id);
                    }
                }
                model2.removeRow(selectedRows[i]);
            }
        }
    }   
}
