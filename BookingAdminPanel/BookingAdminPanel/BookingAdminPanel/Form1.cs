using System;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace BookingAdminPanel
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: данная строка кода позволяет загрузить данные в таблицу "bookingDataSet.Hotels". При необходимости она может быть перемещена или удалена.
            this.hotelsTableAdapter.Fill(this.bookingDataSet.Hotels);
            groupBox1.Visible = false;
            groupBox2.Visible = false;
            groupBox3.Visible = false;
            dataGridView1.Visible = false;
        }

        private void addNewHotelToolStripMenuItem_Click(object sender, EventArgs e)
        {
            groupBox3.Visible = false;
            groupBox1.Visible = true;
            groupBox2.Visible = false;
            dataGridView1.Visible = false;
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            string locationName = textBox1.Text;
            string name = textBox2.Text;
            int category = Convert.ToInt16(textBox3.Text);
            string pictUrl = textBox4.Text;
            BookingDataSet.HotelsDataTable hotels = new BookingDataSet.HotelsDataTable();
            BookingDataSetTableAdapters.HotelsTableAdapter ta = new BookingDataSetTableAdapters.HotelsTableAdapter();
            SqlConnection sda = ta.Connection;
            SqlCommand comm = new SqlCommand("insert into Hotels(hotelLocation,name,hotelCategory,pictUrl) values('" + locationName + "','" + name + "'," + category.ToString() + ",'" + pictUrl + "'" + ")",sda);
            comm.Connection.Open();
            comm.ExecuteNonQuery();
            comm.Connection.Close();
        }

        private void deleteAHotelToolStripMenuItem_Click(object sender, EventArgs e)
        {
            groupBox3.Visible = false;
            groupBox1.Visible = false;
            groupBox2.Visible = true;
            dataGridView1.Visible = false;

        }

        private void button2_Click(object sender, EventArgs e)
        {
            string locationName = textBox5.Text;
            string name = textBox6.Text;
                        
            BookingDataSet.HotelsDataTable hotels = new BookingDataSet.HotelsDataTable();
            BookingDataSetTableAdapters.HotelsTableAdapter ta = new BookingDataSetTableAdapters.HotelsTableAdapter();
            SqlConnection sda = ta.Connection;
            SqlCommand comm = new SqlCommand("delete from Hotels where hotelLocation = '" + locationName + "' and name = '" + name+"'", sda);
            comm.Connection.Open();
            comm.ExecuteNonQuery();
            comm.Connection.Close();
        }

        private void hotelsViewToolStripMenuItem_Click(object sender, EventArgs e)
        {
            groupBox3.Visible = false;
            groupBox1.Visible = false;
            groupBox2.Visible = true;
            dataGridView1.Visible = true;
            
            BookingDataSet.HotelsDataTable hotels = new BookingDataSet.HotelsDataTable();
            BookingDataSetTableAdapters.HotelsTableAdapter ta = new BookingDataSetTableAdapters.HotelsTableAdapter();
            SqlConnection sda = ta.Connection;
            SqlCommand comm = new SqlCommand("select * from Hotels", sda);
            comm.Connection.Open();
            DataTable dt = new DataTable();
            SqlDataAdapter da = new SqlDataAdapter(comm);
            da.Fill(dt);

            dataGridView1.DataSource = dt;
           // dataGridView1.
            comm.Connection.Close();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void addNumberToHotelToolStripMenuItem_Click(object sender, EventArgs e)
        {
            groupBox1.Visible = false;
            groupBox2.Visible = false;
            dataGridView1.Visible = false;
            groupBox3.Visible = true;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            int hotelId = Convert.ToInt16(textBox7.Text);
            int RoomNumber = Convert.ToInt16(textBox8.Text);
            int category = Convert.ToInt16(textBox10.Text);
            float price = (float)Convert.ToDouble(textBox9.Text);
            BookingDataSet.HotelNumbersDataTable hotelNumbers = new BookingDataSet.HotelNumbersDataTable();
            BookingDataSetTableAdapters.HotelNumbersTableAdapter ta = new BookingDataSetTableAdapters.HotelNumbersTableAdapter();
            SqlConnection sda = ta.Connection;
            SqlCommand comm = new SqlCommand("insert into HotelNumbers(number,price,hId,catNum) values(" + RoomNumber.ToString() + "," + price.ToString() + "," + hotelId.ToString() + "," + category.ToString() + ")", sda);
            comm.Connection.Open();
            comm.ExecuteNonQuery();
            comm.Connection.Close();
        }
    }
}
