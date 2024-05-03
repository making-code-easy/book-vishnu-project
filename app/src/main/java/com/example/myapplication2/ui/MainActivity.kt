package com.example.myapplication2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication2.MainApplication
import com.example.myapplication2.databinding.ActivityMainBinding
import com.example.myapplication2.di.component.DaggerAppComponent
import com.example.myapplication2.di.factory.ViewModelProviderFactory
import com.example.myapplication2.ui.diffutils.DiffUtilCallBack
import com.example.myapplication2.ui.uistate.UIState
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(
            LayoutInflater.from(this)
        )
    }

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory
    private lateinit var viewModel: BooksViewModel
    private val myAdapter: BooksAdapter by lazy {
        BooksAdapter(DiffUtilCallBack())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        initInjection()
        setUpViewModel()
        setUpView()
        setUpObserver()

    }

    private fun initInjection() {
        application.let { application ->
            DaggerAppComponent.builder()
                .baseAppComponent((application as MainApplication).getBaseComponent()).build()
                .inject(this)
        }
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[BooksViewModel::class.java]
        viewModel.getBooks()
    }


    private fun setUpView() {
        viewBinding.recyclerView.run {
            layoutManager =
                LinearLayoutManager(this@MainActivity)
            this.adapter = myAdapter
        }
    }

    private fun setUpObserver() {
        viewModel.books.observe(this) {
            when (it) {
                is UIState.Success -> {
                    myAdapter.submitList(it.data)
                    viewBinding.loader.visibility = View.GONE
                }

                is UIState.Fail -> {
                    Toast.makeText(this, it.throwable.message, Toast.LENGTH_SHORT).show()
                    viewBinding.loader.visibility = View.GONE
                }

                is UIState.Loading -> {
                    viewBinding.loader.visibility = View.VISIBLE
                }
            }
        }
    }
}