import React, { useState } from 'react'
import { Header } from '../../components/admin'
import { Button, Input, Option, Select, Textarea } from '@material-tailwind/react'
import { StyledDropzone } from '../../components/admin/Dropzone';
import { useStateContext } from '../../contexts/StateContext';
import ThumbnailServices from '../../services/ThumbnailServices';
import { useParams } from 'react-router-dom';
import useProductContext from '../../hooks/useProductContext';

const ProductForm = (props) => {
    const [image, setImage] = useState([])
    const [errMsg, setErrMsg] = useState('');

    const { isUpload, setIsUpload, images } = useStateContext();
    const { products } = useProductContext();

    const { id } = useParams();
    const product = products.find((product) => { return product.id === id })
    console.log(product)
    // props.name = product.title;
    // props.price = product.price;
    // props.description = product.description;
    const [name, setName] = useState(props?.value ?? '');
    const [price, setPrice] = useState(props?.value ?? '');
    const [description, setDescription] = useState(props?.value ?? '');
    const [category, setCategory] = useState(props?.value ?? '');



    const handleSubmit = async (e) => {
        e.preventDefault();
        setIsUpload(true);

        let formData = new FormData();

        for (var i = 0; i < images.length; i++) {
            let file = images[i];
            formData.append('file', file);
        }

        const product = {
            'name': name,
            'price': price,
            'description': description,
            'category': category
        }
        console.log(images);
        formData.append('product', product)

        ThumbnailServices.postThumbnails(formData);
    }
    return (
        <div className='rounded-3xl border-radious sm:pt-16 m-3 mt-12 md:m-8 p-5 md:p-10 w-auto h-auto max-w-full max-h-full object-contain bg-white'>

            <Header category="Page" title="New product" />
            <form className='flex flex-col space-y-7' onSubmit={handleSubmit} action="">
                <div className='flex'>
                    <Input label='Name' onInput={e => setName(e.target.value)}></Input>
                    <Input type='number' min={0} label='Price' onInput={e => setPrice(e.target.value)}></Input>
                </div>
                <Textarea label='Description' onInput={e => setDescription(e.target.value)}></Textarea>

                <Select label='Category' onSelect={e => setCategory(e.target.value)}>
                    <Option>Material Tailwind HTML</Option>
                    <Option>Material Tailwind React</Option>
                    <Option>Material Tailwind Vue</Option>
                    <Option>Material Tailwind Angular</Option>
                    <Option>Material Tailwind Svelte</Option>
                </Select >

                <StyledDropzone image={image} setImage={setImage} />

                <Button type="submit" className='flex-nowrap'> Add</Button>
            </form>
        </div>
    )
}

export default ProductForm